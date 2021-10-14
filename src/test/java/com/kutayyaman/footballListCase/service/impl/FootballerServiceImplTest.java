package com.kutayyaman.footballListCase.service.impl;

import com.kutayyaman.footballListCase.domain.Footballer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FootballerServiceImplTest {

    @Test
    void findAllFootballerByTeamId(){
        Footballer footballer = new Footballer();
        footballer.setFootballerName("Kutayy");

        assertEquals("Kutayy",footballer.getFootballerName());
    }

}