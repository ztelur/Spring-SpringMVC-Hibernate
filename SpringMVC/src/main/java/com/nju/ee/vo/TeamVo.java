package com.nju.ee.vo;

import java.util.List;
import java.util.Map;

/**
 * Created by homer on 16-10-31.
 */
public class TeamVo {
    private Map<String, List<PersonVo>> team;

    public Map<String, List<PersonVo>> getTeam() {
        return team;
    }

    public void setTeam(Map<String, List<PersonVo>> team) {
        this.team = team;
    }
}
