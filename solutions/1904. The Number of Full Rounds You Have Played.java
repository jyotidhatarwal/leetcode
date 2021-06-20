class Solution {
    public int numberOfRounds(String startTime, String finishTime) {
        int startHour = Integer.parseInt(startTime.substring(0,2));
        int startMinutes = Integer.parseInt(startTime.substring(3,5));
        
        int finishHour = Integer.parseInt(finishTime.substring(0,2));
        int finishMinutes = Integer.parseInt(finishTime.substring(3,5));
        
        if(finishHour < startHour || finishHour == startHour && finishMinutes < startMinutes){
            finishHour += 24;
        }
        int startCount = (int)Math.ceil(startMinutes/15.0);
        int finishCount = (int)Math.floor(finishMinutes/15.0);
        
        return Math.max(0,finishHour*4 + finishCount - (startHour*4 + startCount));
    }
}
