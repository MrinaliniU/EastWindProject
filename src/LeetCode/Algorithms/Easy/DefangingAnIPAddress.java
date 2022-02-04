package LeetCode.Algorithms.Easy;

public class DefangingAnIPAddress {
    /*
        Runtime: 0 ms, faster than 100.00%
        Memory Usage: 37.3 MB, less than 100.00%
     */
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        String[] ipSplit = address.split("\\.");
        int lengthOfIPSplit = ipSplit.length - 1;
        for(int i = 0; i < lengthOfIPSplit; i++){
            sb.append(ipSplit[i]).append("[.]");
        }
        sb.append(ipSplit[lengthOfIPSplit]);
        return sb.toString();
    }
    /*
        Runtime: 5 ms, faster than 11.50%
        Memory Usage: 38.9 MB, less than 100.00%
     */
    public String defangIPaddr2(String address) {
        return address.replaceAll("\\.", "[.]");
    }
}
