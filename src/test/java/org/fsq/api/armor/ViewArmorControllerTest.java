package org.fsq.api.armor;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.fsq.entity.item.armor.Armor;
import org.fsq.io.repo.armor.ArmorRepository;
import org.fsq.util.TestArmorBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
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
        when(armorRepository.fetchArmor(any())).thenReturn(buildTestArmor());
        MockHttpServletRequestBuilder b = get("/armor/view/1");
        MvcResult res = this.mockMvc.perform(b).andReturn();
        assertEquals("armor/viewArmor", res.getModelAndView().getViewName());
        assertEquals("Test Armor",((Armor) res.getModelAndView().getModel().get("armor")).getNameUnique());
    }

    @Test
    public void testViewArmorFail() throws Exception {
        when(armorRepository.fetchArmor(any())).thenReturn(null);
        MockHttpServletRequestBuilder b = get("/armor/view/1");
        MvcResult res = this.mockMvc.perform(b).andReturn();
        assertTrue(res.getModelAndView().getModel().isEmpty());
        assertTrue(res.getModelAndView().getViewName().contains("redirect"));
    }

    public Armor buildTestArmor() {
        return TestArmorBuilder.buildTestArmor("Test Armor", 1L);
    }
}