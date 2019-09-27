


public class NumericQuestion extends Question
{
    private double answer;
    
    // this is an example of method overloading.
    // This method overloads the setAnswer method of the Question class
    public void setAnswer(double correctResponse) {
        answer = correctResponse;
    }
    
    // this is an example of method overriding
    // thismethod overrides the checkAnswer method of the the Question class 
    public boolean
    checkAnswer(String response) {
        double responseAsDouble = Double.parseDouble(response);
        return Math.abs( responseAsDouble - answer ) <= 0.01;
    }
}
