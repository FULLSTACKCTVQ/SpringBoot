package wel.devjava.picoledrone.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity



public class Anime {
    //@Id
    //@GeneratedValue(strategy = GenerationType.)

    private Long id;
    private String name;


}


//private String cpf;
//private String endereco;
//private Long apt;
//private String cidade;


//@JsonProperty("name") esse atributo mascara o campo real e direciona ao campo em exibição ex campo real name campo de exibição NameCliente


