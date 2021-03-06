package org.ahea.export.sql;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.ahea.export.Exporter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest
public class SqlBuilderSqlExporterTest {

    @Autowired
    Exporter sqlBuilderSqlExporter;

    @Test
    public void singleParamDefaultOptionExport() throws Exception {

        //Given
        Map<String, Object> data = new HashMap<>();
        data.put("이름", "김민수");
        data.put("나이", 25);
        data.put("성별", "남");

        //When
        String testResult = sqlBuilderSqlExporter.export(data, null);

        //Then
        System.out.println("\n");
        log.info("testResult ::: {}", testResult);
    }

    @Test
    public void multiParamDefaultOptionExport() throws Exception {

        //Given
        List<Map<String, Object>> datas = new ArrayList<>();
        String[] names = {"김민수", "김민순", "김민주"};
        String[] genders = {"M", "W", "M"};
        int[] ages = {25, 28, 35};
        for (int i = 0; i<names.length; i++){
            Map<String, Object> data = new HashMap<>();
            data.put("이름", names[i]);
            data.put("성별", genders[i]);
            data.put("나이", ages[i]);
            datas.add(data);
        }

        //When
        String testResult = sqlBuilderSqlExporter.export(datas, null);

        //then
        log.info("testResult ::: \n{}", testResult);

    }

}