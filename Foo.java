/*
effective-java [chapter 1]
생성자 대신 정적 팩토리 메서드를 고려하라
*/

import java.util.EnumSet;

public class Foo {

    String name;
    String address;

    public Foo() {

    }

    private static final Foo GOOD_NIGHT = new Foo();

    public Foo(String name) {
        this.name = name;
    }

    public static Foo withName(String name) {
        return new Foo(name);
    }

    public static Foo withAddress(String address) {
        Foo foo = new Foo();
        foo.address = address;
        return foo;
    }

    public static Foo getFoo() {
        return GOOD_NIGHT;
    }

    // Foo를 상속받는 다른 클래스를 만들어서 사용할 때, public static 팩토리 메소드를 작성하는 시점에
    // 리턴하는 객체의 클래스가 반드시 존재하지 않아도 된다.
    public static Foo getFoo(boolean flag) {
        Foo foo = new Foo();

        // TODO 어떤 특정 약속 되어 있는 텍스트 파일에서 Foo의 구현체의 FQCN을 읽어온다.
        // TODO FQCN 에 해당하는 인스턴스를 생성한다.
        // TODO foo 변수를 해당 인스턴스를 가리키도록 수정한다.

        return foo;
    }

    public static void main(String[] args) {

        // 생성자 호출 방식의 기존 인스턴스 호출 방식
        Foo foo = new Foo("h-dragon");
        // 메소드 이름으로 유추 가능하도록 호출 가능
        Foo foo1 = Foo.withName("h-Dragon");
        // 객체를 매번 생성하지 않고 인스턴스를 사용 가능
        Foo foo2 = Foo.getFoo();
        // 리턴하는 객체의 클래스가 입력 매개변수에 따라 매번 다를 수 있음
        Foo foo3 = Foo.getFoo(false);

        EnumSet<Color> colors = EnumSet.allOf(Color.class);

        EnumSet<Color> blueAndWhite =  EnumSet.of(Color.BLUE, Color.WHITE);
    }

    static class BarFoo extends Foo {

    }

    enum Color {
        RED, BLUE, WHITE
    }

    // private static 메소드 사용법
    public static void doSomething() {
        // Todo 오늘 할 일
        SameRoutine();
    }
    
    public static void doSomethingTommorrow() {
        // Todo 내일 할 일
        SameRoutine();
    }

    private static void SameRoutine() {

    }

}
