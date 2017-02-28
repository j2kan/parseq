package com.linkedin.parseq.lambda;

import java.util.Optional;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class TestMethodRef extends BaseTest {

  private static final String CLASSNAME = TestMethodRef.class.getSimpleName();

  TestMethodRef field = this;

  @Test
  public void testFunctionOnThis() {
    Optional<LambdaClassDescription> description = getDescriptionForFunction(this::function);
    assertTrue(description.isPresent());
    assertNameMatch("this::function", "testFunctionOnThis", CLASSNAME, description.get().toString());
  }

  @Test
  public void testCallableOnThis() {
    Optional<LambdaClassDescription> description = getDescriptionForCallable(this::callable);
    assertTrue(description.isPresent());
    assertNameMatch("this::callable", "testCallableOnThis", CLASSNAME, description.get().toString());
  }

  @Test
  public void testConsumerOnThis() {
    Optional<LambdaClassDescription> description = getDescriptionForConsumer(this::consumer);
    assertTrue(description.isPresent());
    assertNameMatch("this::consumer", "testConsumerOnThis", CLASSNAME, description.get().toString());
  }

  @Test
  public void testFunctionOnStaticField() {
    Optional<LambdaClassDescription> description = getDescriptionForFunction(staticField::function);
    assertTrue(description.isPresent());
    assertNameMatch("staticField::function", "testFunctionOnStaticField", CLASSNAME, description.get().toString());
  }

  @Test
  public void testCallableOnStaticField() {
    Optional<LambdaClassDescription> description = getDescriptionForCallable(staticField::callable);
    assertTrue(description.isPresent());
    assertNameMatch("staticField::callable", "testCallableOnStaticField", CLASSNAME, description.get().toString());
  }

  @Test
  public void testConsumerOnStaticField() {
    Optional<LambdaClassDescription> description = getDescriptionForConsumer(staticField::consumer);
    assertTrue(description.isPresent());
    assertNameMatch("staticField::consumer", "testConsumerOnStaticField", CLASSNAME, description.get().toString());
  }

  @Test
  public void testFunctionOnField() {
    Optional<LambdaClassDescription> description = getDescriptionForFunction(field::function);
    assertTrue(description.isPresent());
    assertNameMatch("field::function", "testFunctionOnField", CLASSNAME, description.get().toString());
  }

  @Test
  public void testCallableOnField() {
    Optional<LambdaClassDescription> description = getDescriptionForCallable(field::callable);
    assertTrue(description.isPresent());
    assertNameMatch("field::callable", "testCallableOnField", CLASSNAME, description.get().toString());
  }

  @Test
  public void testConsumerOnField() {
    Optional<LambdaClassDescription> description = getDescriptionForConsumer(field::consumer);
    assertTrue(description.isPresent());
    assertNameMatch("field::consumer", "testConsumerOnField", CLASSNAME, description.get().toString());
  }

  @Test
  public void testFunctionWithTwoParams() {
    Optional<LambdaClassDescription> description = getDescriptionForBiFunction(this::functionTwo);
    assertTrue(description.isPresent());
    assertNameMatch("this::functionTwo", "testFunctionWithTwoParams", CLASSNAME, description.get().toString());
  }

  @Test
  public void testConsumerWithTwoParams() {
    Optional<LambdaClassDescription> description = getDescriptionForBiConsumer(this::consumerTwo);
    assertTrue(description.isPresent());
    assertNameMatch("this::consumerTwo", "testConsumerWithTwoParams", CLASSNAME, description.get().toString());
  }

  @Test
  public void testFunctionOnVar() {
    BaseTest localVar = noParamMethod();
    Optional<LambdaClassDescription> description = getDescriptionForFunction(localVar::function);
    assertTrue(description.isPresent());
    assertNameMatch("localVar::function", "testFunctionOnVar", CLASSNAME, description.get().toString());
  }

  @Test
  public void testCallableOnVar() {
    BaseTest localVar = noParamMethod();
    Optional<LambdaClassDescription> description = getDescriptionForCallable(localVar::callable);
    assertTrue(description.isPresent());
    assertNameMatch("localVar::callable", "testCallableOnVar", CLASSNAME, description.get().toString());
  }

  @Test
  public void testConsumerOnVar() {
    BaseTest localVar = noParamMethod();
    Optional<LambdaClassDescription> description = getDescriptionForConsumer(localVar::consumer);
    assertTrue(description.isPresent());
    assertNameMatch("localVar::consumer", "testConsumerOnVar", CLASSNAME, description.get().toString());
  }

  @Test
  public void testFunctionOnNoParamMethod() {
    Optional<LambdaClassDescription> description = getDescriptionForFunction(noParamMethod()::function);
    assertTrue(description.isPresent());
    assertNameMatch("noParamMethod()::function", "testFunctionOnNoParamMethod", CLASSNAME,
        description.get().toString());
  }

  @Test
  public void testCallableOnNoParamMethod() {
    Optional<LambdaClassDescription> description = getDescriptionForCallable(noParamMethod()::callable);
    assertTrue(description.isPresent());
    assertNameMatch("noParamMethod()::callable", "testCallableOnNoParamMethod", CLASSNAME,
        description.get().toString());
  }

  @Test
  public void testConsumerOnNoParamMethod() {
    Optional<LambdaClassDescription> description = getDescriptionForConsumer(noParamMethod()::consumer);
    assertTrue(description.isPresent());
    assertNameMatch("noParamMethod()::consumer", "testConsumerOnNoParamMethod", CLASSNAME,
        description.get().toString());
  }

  @Test
  public void testFunctionOnNoParamStaticMethod() {
    Optional<LambdaClassDescription> description = getDescriptionForFunction(noParamStaticMethod()::function);
    assertTrue(description.isPresent());
    assertNameMatch("noParamStaticMethod()::function", "testFunctionOnNoParamStaticMethod", CLASSNAME,
        description.get().toString());
  }

  @Test
  public void testCallableOnNoParamStaticMethod() {
    Optional<LambdaClassDescription> description = getDescriptionForCallable(noParamStaticMethod()::callable);
    assertTrue(description.isPresent());
    assertNameMatch("noParamStaticMethod()::callable", "testCallableOnNoParamStaticMethod", CLASSNAME,
        description.get().toString());
  }

  @Test
  public void testConsumerOnNoParamStaticMethod() {
    Optional<LambdaClassDescription> description = getDescriptionForConsumer(noParamStaticMethod()::consumer);
    assertTrue(description.isPresent());
    assertNameMatch("noParamStaticMethod()::consumer", "testConsumerOnNoParamStaticMethod", CLASSNAME,
        description.get().toString());
  }

  @Test
  public void testFunctionOnParamStaticMethod() {
    Optional<LambdaClassDescription> description = getDescriptionForFunction(paramStaticMethod(0, "")::function);
    assertTrue(description.isPresent());
    assertNameMatch("paramStaticMethod(_,_)::function", "testFunctionOnParamStaticMethod", CLASSNAME,
        description.get().toString());
  }

  @Test
  public void testCallableOnParamStaticMethod() {
    Optional<LambdaClassDescription> description = getDescriptionForCallable(paramStaticMethod(Long.MAX_VALUE, "")::callable);
    assertTrue(description.isPresent());
    assertNameMatch("paramStaticMethod(_,_)::callable", "testCallableOnParamStaticMethod", CLASSNAME,
        description.get().toString());
  }

  @Test
  public void testConsumerOnParamStaticMethod() {
    Optional<LambdaClassDescription> description = getDescriptionForConsumer(paramStaticMethod(Long.MAX_VALUE, "")::consumer);
    assertTrue(description.isPresent());
    assertNameMatch("paramStaticMethod(_,_)::consumer", "testConsumerOnParamStaticMethod", CLASSNAME,
        description.get().toString());
  }

  @Test
  public void testFunctionOnParamMethod() {
    Optional<LambdaClassDescription> description = getDescriptionForFunction(paramMethod(0, "")::function);
    assertTrue(description.isPresent());
    assertNameMatch("paramMethod(_,_)::function", "testFunctionOnParamMethod", CLASSNAME, description.get().toString());
  }

  @Test
  public void testCallableOnParamMethod() {
    Optional<LambdaClassDescription> description = getDescriptionForCallable(paramMethod(Long.MAX_VALUE, "")::callable);
    assertTrue(description.isPresent());
    assertNameMatch("paramMethod(_,_)::callable", "testCallableOnParamMethod", CLASSNAME, description.get().toString());
  }

  @Test
  public void testConsumerOnParamMethod() {
    Optional<LambdaClassDescription> description = getDescriptionForConsumer(paramMethod(Long.MAX_VALUE, "")::consumer);
    assertTrue(description.isPresent());
    assertNameMatch("paramMethod(_,_)::consumer", "testConsumerOnParamMethod", CLASSNAME, description.get().toString());
  }

  @Test
  public void testNewInstance() {
    Optional<LambdaClassDescription> description = getDescriptionForCallable(new String("abc")::toString);
    assertTrue(description.isPresent());
    assertNameMatch("new String()::toString", "testNewInstance", CLASSNAME, description.get().toString());
  }
}