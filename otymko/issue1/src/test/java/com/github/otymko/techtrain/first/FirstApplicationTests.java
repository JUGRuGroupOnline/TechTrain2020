package com.github.otymko.techtrain.first;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest(
  classes = FirstApplication.class
)
@AutoConfigureMockMvc
class FirstApplicationTests {

  @Autowired
  private MockMvc mvc;

  @Test
  void testHome() throws Exception {
    // given
    var url = "/";

    // when
    ResultActions resultActions = this.mvc.perform(get(url));

    // then
    resultActions.andExpect(content().string("Мы"));
  }

}
