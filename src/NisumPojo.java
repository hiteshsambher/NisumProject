
public class NisumPojo {

	private String lowerLimit;
	private String upperLimit;
	private boolean flag;
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public String getLowerLimit() {
		return lowerLimit;
	}
	public void setLowerLimit(String lowerLimit) {
		this.lowerLimit = lowerLimit;
	}
	public String getUpperLimit() {
		return upperLimit;
	}
	public void setUpperLimit(String upperLimit) {
		this.upperLimit = upperLimit;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "["+lowerLimit+","+upperLimit+"]";
	}
	
}
