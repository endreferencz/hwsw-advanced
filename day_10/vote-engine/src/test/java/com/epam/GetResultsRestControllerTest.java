package com.epam;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.vote.VoteEngineApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {VoteEngineApplication.class}, webEnvironment = WebEnvironment.RANDOM_PORT)
@Transactional
public class GetResultsRestControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testVoteResults() throws Exception {
        ResponseEntity<String> result = restTemplate.getForEntity("/api/results", String.class);
        Assert.assertEquals("{\"votes\":{\"A\":0,\"B\":0,\"C\":0,\"D\":0}}", result.getBody());
    }

    @Test
    public void testVote() throws Exception {
        mvc.perform(post("/vote").sessionAttr("voted", false).param("name", "A")).andReturn();
        mvc.perform(post("/vote").sessionAttr("voted", false).param("name", "A")).andReturn();
        mvc.perform(get("/api/results")).andExpect(jsonPath("votes.A").value(2));
    }

}
