package utils;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Logs {
    public void IniciarLogCSV(String dataHora) throws IOException {
        String[] cabecalho = {"date e hora", "caso de teste", "mensagem"};
        Writer escritor = Files.newBufferedWriter(Paths.get("target/logs/log-" + dataHora + ".csv") );
        CSVWriter escritorCSV = new CSVWriter(escritor);

        escritorCSV.writeNext(cabecalho);

        escritorCSV.flush();
        escritor.close();
    }

    public void registrarCSV(String dataHora, String casoDeTeste, String mensagem) throws IOException {
        String dataHoraLog = new SimpleDateFormat("[yyyy/MM/dd HH:mm:ss:ms] ").format(Calendar.getInstance().getTime());
        List<String[]> linha = new ArrayList<>();
        linha.add(new String[]{dataHoraLog, casoDeTeste,mensagem});
        //linha.add(new String[]{"2021-07-14 20-36-05", "Mantis","Iniciou o teste"});

        FileWriter escritor = new FileWriter(("target/logs/log-" + dataHora + ".csv"), true);
        CSVWriter escritorCSV = new CSVWriter(escritor);

        escritorCSV.writeAll(linha, true);


        escritorCSV.flush();
        escritor.close();
    }
}