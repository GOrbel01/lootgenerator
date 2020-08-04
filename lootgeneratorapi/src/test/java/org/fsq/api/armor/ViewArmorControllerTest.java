package org.fsq.api.armor;

import static org.mockito.ArgumentMatchers.any;

import org.fsq.entity.item.equipment.armor.Armor;
import org.fsq.util.TestArmorBuilder;
import org.fsq.io.repo.armor.ArmorRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ViewArmorControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @MockBean
    private ArmorRepository armorRepository;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testViewArmorSuccess() throws Exception {
        Mockito.when(armorRepository.fetchArmor(ArgumentMatchers.any())).thenReturn(buildTestArmor());
        MockHttpServletRequestBuilder b = MockMvcRequestBuilders.get("/armor/view/1");
        MvcResult res = this.mockMvc.perform(b).andReturn();
        Assert.assertEquals("armor/viewArmor", res.getModelAndView().getViewName());
        Assert.assertEquals("Test Armor",((Armor) res.getModelAndView().getModel().get("armor")).getNameUnique());
    }

    @Test
    public void testViewArmorFail() throws Exception {
        Mockito.when(armorRepository.fetchArmor(ArgumentMatchers.any())).thenReturn(null);
        MockHttpServletRequestBuilder b = MockMvcRequestBuilders.get("/armor/view/1");
        MvcResult res = this.mockMvc.perform(b).andReturn();
        Assert.assertTrue(res.getModelAndView().getModel().isEmpty());
        Assert.assertTrue(res.getModelAndView().getViewName().contains("redirect"));
    }

    private Armor buildTestArmor() {
        return TestArmorBuilder.buildTestArmor("Test Armor", 1L);
    }
}