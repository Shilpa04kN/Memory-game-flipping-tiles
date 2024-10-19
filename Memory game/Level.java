public class Level {
	int xy = 4;
	  int l = 1;

	  public int getLevel() {
	    return 1;
	  }
	  public int setXY(int l){
	    xy = l*4;
	    return xy;
	  }

	  public int getXY(){
	    return xy;
	  }

	  public int upLevel(){
	    l++;
	    return l;
	  }

	  public void printLevel(){
	    System.out.println("        Level " + l + "   ");
    }
	}