package com.qa.test.Guru99Test;

import static org.junit.Assert.assertEquals;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StackSteps {

	private StackExample myStack;
	private Object pushed;
	private Object popped;

	@Given("^an empty stack$")
	public void an_empty_stack() {
		myStack = new StackExample();
	}

	@When("^I push an item into the stack$")
	public void i_push_an_item_into_the_stack() {
		pushed = new Object();
		myStack.push(pushed);
	}

	@Then("^the stack contains one item$")
	public void the_stack_contains_one_item() {
		myStack.size();
		assertEquals(1,myStack.size());
	}

	@When("^I push another item into the stack$")
	public void i_push_another_item_into_the_stack() {
		myStack.push(pushed);
	}

	@Then("^the stack contains two items$")
	public void the_stack_contains_two_items() {
		myStack.size();
		assertEquals(2,myStack.size());
	}

	@When("^I pop from the stack$")
	public void i_pop_from_the_stack() {
		popped = myStack.pop();
	}

	@Then("^I get the same item back$")
	public void i_get_the_same_item_back() {
		assertEquals("Not the same", pushed, popped);
	}


	@Given("^a stack with (\\d+) things$")
	public void a_stack_with_things(int arg1){
		myStack = new StackExample();
		pushed = new Object();
		for(int i=0;i<arg1;i++) {
			myStack.push(pushed);
		}
	}
	
}

