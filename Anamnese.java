public class Anamnese {

    private static long idClasse = 0;
    private long id;
    private String motivo, historico, queixa;
    private Paciente paciente;

    public void setAnamnese(String motivo, String historico, String queixa, Paciente paciente) {
        this.motivo = motivo;
        this.historico = historico;
        this.queixa = queixa;
        this.paciente = paciente;
        this.id = idClasse;
        idClasse++;
    }

    public void setAtualizarAnamnese(String motivo, String historico, String queixa, Paciente paciente){
        this.motivo = motivo;
        this.historico = historico;
        this.queixa = queixa;
        this.paciente = paciente;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getHistorico() {
        return historico;
    }

    public String getQueixa() {
        return queixa;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public long getId() {
        return id;
    }

}