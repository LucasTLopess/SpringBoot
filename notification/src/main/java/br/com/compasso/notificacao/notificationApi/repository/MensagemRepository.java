package br.com.compasso.notificacao.notificationApi.repository;

import br.com.compasso.notificacao.notificationApi.model.Mensagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensagemRepository extends JpaRepository<Mensagem, Long>{

}
