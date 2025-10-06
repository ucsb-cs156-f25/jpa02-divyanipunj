package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test 
    public void equals_returns_true_for_equal_teams() {
        Team team2 = team;
        assert(team.equals(team2));
    }

    @Test 
    public void equals_returns_false_for_different_teams() {
        Team team2 = new Team("test-team-2");
        assert(!team.equals(team2));
    }

    @Test 
    public void equals_returns_false_for_different_objects() {
        String team2 = "not-a-team";
        assert(!team.equals(team2));
    }

    @Test
    public void equals_returns_false_for_diff_teams_same_name(){
        Team team2 = new Team("test-team");
        team2.addMember("Alice");
        assert(!team.equals(team2));
    }

    @Test
    public void equals_returns_false_for_same_teams_diff_name(){
        Team team2 = new Team("test-team-2");
        team2.addMember("Alice");
        assert(!team.equals(team2));
    }

    @Test
    public void hashCode_returns_same_value_for_equal_teams(){
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());

        Team obj3 = new Team();
        int result = obj3.hashCode();
        int expectedResult = 1;
        assertEquals(expectedResult, result);
    }
}
