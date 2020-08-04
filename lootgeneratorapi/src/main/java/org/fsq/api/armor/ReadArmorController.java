package org.fsq.api.armor;

import org.fsq.entity.item.equipment.armor.Armor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/armor/view")
public class ReadArmorController extends ArmorController {
    @GetMapping("/{id}")
    public String showArmor(Model model, @PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        Armor armor = getArmorRepository().fetchArmor(id);
        if (armor == null) {
            redirectAttributes.addFlashAttribute("Failed");
            redirectAttributes.addFlashAttribute("alertClass", "alert-error");
            redirectAttributes.addFlashAttribute("message", "Item does not exist");
            return "redirect:/armor/view/result";
        }
        model.addAttribute("armor", armor);
        return "armor/viewArmor";
    }

    @GetMapping("/result")
    public String getResult() {
        return "general/errorpage";
    }
}
