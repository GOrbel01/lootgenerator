package org.fsq.api.armor;

import org.fsq.entity.item.armor.Armor;
import org.fsq.entity.stats.Stat;
import org.fsq.io.repo.armor.ArmorRepository;
import org.fsq.io.repo.stat.StatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/armor/add")
public class AddArmorController extends ArmorController {

    @GetMapping("")
    public String armorForm(Model model) {
        model.addAttribute("armor", new Armor());
        return "armor/armform";
    }

    @PostMapping("")
    public String armorSubmit(@ModelAttribute Armor armor, BindingResult result, RedirectAttributes redirectAttributes, Model model) {
        model.addAttribute("armview", armor);
        filterOutZeroStatResults(armor);
        redirectAttributes.addFlashAttribute("Failed");
        redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
        if (result.hasErrors()) {
            return "redirect:/armor/add/result";
        }
        getArmorRepository().save(armor);
        redirectAttributes.addFlashAttribute("result", "Success");
        redirectAttributes.addFlashAttribute("message", buildMessage(armor.getNameUnique()));
        redirectAttributes.addFlashAttribute("alertClass", "alert-success");
        return "redirect:/armor/add/result";
    }

    @GetMapping("/result")
    public String armorResult(Model model) {
        model.addAttribute("armor", new Armor());
        return "armor/addArmResult";
    }

    private void filterOutZeroStatResults(Armor armor) {
        armor.setStats(armor.getStats().stream().
                filter(stat -> stat.getStatValue() != null)
                .collect(Collectors.toList()));
    }

    private String buildMessage(String itemName) {
        return "Added item named: " + itemName + ".";
    }
}
