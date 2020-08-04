package org.fsq.mapper.item.armor;

import org.fsq.dto.item.armor.ArmorDto;
import org.fsq.dto.item.armor.detail.ArmorPropertiesDto;
import org.fsq.dto.stats.armor.ArmorStatValuesDto;
import org.fsq.dto.types.ArmorTypesDto;
import org.fsq.entity.item.equipment.armor.Armor;
import org.fsq.entity.item.equipment.armor.detail.ArmorProperties;
import org.fsq.entity.item.equipment.types.ArmorTypes;
import org.fsq.entity.stats.armor.ArmorStatValues;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED, componentModel = "spring")
public interface ArmorMapper {
    @Mapping(target = "id")
    ArmorDto armorToArmorDto(Armor armor);
    @Mapping(target = "id")
    ArmorPropertiesDto armorPropToArmorPropDto(ArmorProperties armorProperties);
    @Mapping(target = "id")
    ArmorStatValuesDto armorStatToArmorStatDto(ArmorStatValues armorStatValues);
    @Mapping(target = "id")
    ArmorTypesDto armorTypesToArmorTypesDto(ArmorTypes armorTypes);

    @Mapping(target = "id")
    Armor armorDtoToArmor(ArmorDto armor);
    @Mapping(target = "id")
    ArmorProperties armorPropDtoToArmorProp(ArmorPropertiesDto armorProperties);
    @Mapping(target = "id")
    ArmorStatValues armorStatDtoToArmorStat(ArmorStatValuesDto armorStatValues);
    @Mapping(target = "id")
    ArmorTypes armorTypesDtoToArmorTypes(ArmorTypesDto armorTypes);
}
