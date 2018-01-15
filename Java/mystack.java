import java.util.*;
class mystack
{
	public static void main(String[] args) {
		Stack st = new Stack();

		st.push("kish");
		st.push("hars");
		st.push("pooj");
		st.push("laks");
		st.push("anand");

		System.out.println(st);
		
		st.pop();

		System.out.println(st);
	}
}