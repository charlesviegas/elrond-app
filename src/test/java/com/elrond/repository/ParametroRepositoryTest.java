package com.elrond.repository;

import com.elrond.entity.Parametro;
import com.elrond.utils.RespositoryTest;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@RespositoryTest
@DatabaseSetup(ParametroRepositoryTest.DATASET)
@DatabaseTearDown(type = DatabaseOperation.DELETE_ALL, value = {ParametroRepositoryTest.DATASET})
public class ParametroRepositoryTest {

    protected static final String DATASET = "classpath:datasets/parametros.xml";

    @Autowired
    private ParametroRepository parametroRepository;

    @Test
    public void testCosultaPorFiltro() {
        assertThat(parametroRepository.buscarParametroPorFiltro("spring"))
                .hasSize(4);
        assertThat(parametroRepository.buscarParametroPorFiltro("Senha"))
                .hasSize(1);
    }

    @Test
    public void testFindAll() {
        assertThat(parametroRepository.findAll())
                .hasSize(4);
    }

    @Test
    public void testFindOne() {
        assertThat(parametroRepository.findOne(1L))
                .doesNotHaveSameClassAs(Parametro.class);
    }

}
