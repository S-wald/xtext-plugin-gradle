package org.xtext.example.mydsl.ui.tests;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.ui.testing.AbstractEditorTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.xtext.example.mydsl.myDsl.Model;
import com.google.inject.Inject;
import com.google.inject.Provider;

import static org.eclipse.emf.common.util.URI.createURI;

@RunWith(XtextRunner.class)
@InjectWith(MyDslUiInjectorProvider.class)
public class EditorTest extends AbstractEditorTest {
	
	@Inject
	private ValidationTestHelper validationHelper;
	
	@Inject
	private ParseHelper<Model> parseHelper;
	
	@Inject
	private Provider<ResourceSet> rsp;

	@Test
	public void test() throws Exception {
		
		var file = dslFile("test-project", 
				"file1", 
				"mydsl", 
				"Hello World");
		var resource = rsp.get().createResource(createURI(file.getLocationURI().toString()));
		var editor = openEditor(file);
		var result = parseHelper.parse("Hello World!");
		validationHelper.assertNoIssues(result);
	}

}
