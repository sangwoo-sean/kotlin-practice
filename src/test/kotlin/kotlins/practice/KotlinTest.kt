import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class KotlinTest {

    @Test
    fun basicTest() {
        val message = "message"
        val number = 10
        val number2: Int = 10
        var number3: Int = 10 //코틀린은 기본형 없이 참조형만 사용!
        val n1 = null
        var n2 = null
        var n3: String = "null"
//        var n3: String = null //컴파일에러
        var n4: String? = null

        println(n3.length)
//        println(n4.length) // 컴파일에러
//        println(n4!!.length) // NPE

        assertThat(message).isEqualTo("message")
        assertThat(number).isEqualTo(10)
        assertThat(number2).isEqualTo(10)
        assertThat(number3).isEqualTo(10)
        number3 = 5
        assertThat(number3).isEqualTo(5)

        println(n4?.length ?: "null~")

        val sum = sum(3, 5)
        assertThat(sum).isEqualTo(8)

        printSum(2, 3)
        printSum()
        val sumMultiple = sumMultiple(1, 2, 3, 4)
        println("sumMultiple = $sumMultiple")

        var result = highOrder({ x, y -> x + y }, 10, 20)
        println(result)

        result = highOrder(::sum, 10, 20)
        println(result)

        withArgs("Arg1", "Arg2", { a, b -> "Hello World! $a $b" })
        withArgs("Arg1", "Arg2") { a, b -> "Hello World! $a $b" } // 함수의 마지막 인자가 람다식인 경우 소괄호 바깥으로 분리 가능

        val add: (Int, Int) -> Int = fun(x: Int, y: Int): Int = x + y //익명함수
        val add2 = fun(x: Int, y: Int): Int = x + y //익명함수
        val add3 = { x: Int, y: Int -> x + y } //익명함수
        println(add(10, 2))
    }

    fun sum(a: Int, b: Int) = a + b

    fun printSum(a: Int = 0, b: Int = 0): Unit {
        println("sum : ${a + b}")
    }

    fun sumMultiple(vararg nums: Int): Int {
        return nums.sum()
    }

    fun highOrder(sum: (Int, Int) -> Int, a: Int, b: Int): Int {
        return sum(a, b)
    }

    fun withArgs(a: String, b: String, out: (String, String) -> String) {
        println(out(a, b))
    }


}

