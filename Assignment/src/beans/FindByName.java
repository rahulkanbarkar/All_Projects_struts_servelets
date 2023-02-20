package beans;

import org.apache.struts.action.ActionForm;

public class FindByName extends ActionForm {
private String name;

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

}
