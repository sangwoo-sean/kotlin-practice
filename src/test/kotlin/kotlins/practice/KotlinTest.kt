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

        highOrder({ x, y -> x + y }, 10, 20)
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
}

