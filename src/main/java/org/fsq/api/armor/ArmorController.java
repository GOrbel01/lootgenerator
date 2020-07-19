package org.fsq.api.armor;

import org.fsq.entity.item.armor.Armor;
import org.fsq.entity.item.types.ArmorTypes;
import org.fsq.entity.stats.Stat;
import org.fsq.io.repo.armor.ArmorRepository;
import org.fsq.io.repo.stat.StatRepository;
import org.fsq.io.repo.types.ArmorTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ArmorController {
    @Autowired
    private ArmorRepository armorRepository;

    @Autowired
    private StatRepository statRepository;

    @Autowired
    private ArmorTypeRepository armorTypeRepository;

    @ModelAttribute("statMap")
    public Map<String, String> getStatMappings() {
        Map<String, String> result = new HashMap<>();
        List<Stat> stats = statRepository.findAll();
        for (Stat stat : stats) {
            result.put(String.valueOf(stat.getId()), stat.getStatName());
        }
        return result;
    }

    @ModelAttribute("allStats")
    public List<Stat> getAllStats() {
        List<Stat> statList = statRepository.findAll();
        return statList;
    }

    @ModelAttribute("allArmorTypes")
    public List<ArmorTypes> getAllArmorTypes() {
        List<ArmorTypes> armTypeList = armorTypeRepository.findAll();
        return armTypeList;
    }

    protected ArmorRepository getArmorRepository() {
        return armorRepository;
    }

    protected StatRepository getStatRepository() {
        return statRepository;
    }

    protected ArmorTypeRepository getArmorTypeRepository() {
        return armorTypeRepository;
    }
}
