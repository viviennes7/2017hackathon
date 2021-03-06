package org.ahea.build.service;

import lombok.extern.apachecommons.CommonsLog;
import lombok.extern.slf4j.Slf4j;
import org.ahea.build.entity.FieldCategory;
import org.ahea.build.entity.FieldData;
import org.ahea.build.repository.FieldDataRepository;
import org.ahea.build.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RepoService implements GenerateDataInterface {

    @Autowired
    FieldDataRepository fieldDataRepository;

    @Override
    public String genetateData(FieldCategory fieldCategory) {

        Integer count = fieldDataRepository.countByFieldCategoryId(fieldCategory.getDataType());

        Random random = new Random();
        int index = random.nextInt(count) + 1;
        FieldData fieldData = fieldDataRepository.findByFieldCategoryIdAndRowNum(
                fieldCategory.getDataType(), index
        );
        return fieldData.getData();

    }
}
