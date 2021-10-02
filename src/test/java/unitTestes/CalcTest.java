package unitTestes;

import devcalc.Calc;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class CalcTest {
    @Test
    public void testarSomarDoisNumeros() {
        // 1 - Prepara - Configurar  - Given
        int num1 = 5;
        int num2 = 7;
        int resultadoEsperado = 12;

        //2 - Executar - When
        int resultadoAtual = Calc.somarDoisNumeros(num1, num2);

        // 3 - Validar - Then
        System.out.println("| O resultado Esperado é " + resultadoEsperado + " |" + "\n| O resultado Atual é    " + resultadoAtual + " |");
        assertEquals(resultadoEsperado,resultadoAtual);
    }
    @Test
    public void testarMain(){
// em progresso
    }

}
