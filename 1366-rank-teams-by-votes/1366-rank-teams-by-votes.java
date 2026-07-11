import java.util.*;

class Solution {
    public String rankTeams(String[] votes) {
        int n = votes[0].length();

        // votesCount[team][position]
        int[][] votesCount = new int[26][n];

        // Count votes for each position
        for (String vote : votes) {
            for (int i = 0; i < n; i++) {
                votesCount[vote.charAt(i) - 'A'][i]++;
            }
        }

        Character[] teams = new Character[n];
        for (int i = 0; i < n; i++) {
            teams[i] = votes[0].charAt(i);
        }

        Arrays.sort(teams, (a, b) -> {
            for (int i = 0; i < n; i++) {
                if (votesCount[a - 'A'][i] != votesCount[b - 'A'][i]) {
                    return votesCount[b - 'A'][i] - votesCount[a - 'A'][i];
                }
            }
            return a - b; // Alphabetical order if completely tied
        });

        StringBuilder result = new StringBuilder();
        for (char team : teams) {
            result.append(team);
        }

        return result.toString();
    }
}