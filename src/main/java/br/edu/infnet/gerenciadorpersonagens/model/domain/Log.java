package br.edu.infnet.gerenciadorpersonagens.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Setter
@Getter
@ToString
@Entity
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String ip;
    private String acao;
    private LocalDateTime data;
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Log() {}

    public Log(String ip, String acao, String descricao, Usuario usuario) {
        setIp(ip);
        this.acao = acao;
        this.data = LocalDateTime.now();
        this.descricao = descricao;
        this.usuario = usuario;
    }

    public void setIp(String ip) {
        if (ip.equalsIgnoreCase("0:0:0:0:0:0:0:1")) {
            try {
                this.ip = InetAddress.getLocalHost().getHostAddress();
            }
            catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
        else {
            this.ip = ip;
        }
    }

    public String formatarData() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return this.data.format(formato);
    }
}
