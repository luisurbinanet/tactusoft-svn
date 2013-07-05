package co.com.tactusoft.dialer.dao;

import java.io.Serializable;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import co.com.tactusoft.dialer.dao.entities.Agent;
import co.com.tactusoft.dialer.dao.entities.AstTrunkDialpatterns;
import co.com.tactusoft.dialer.dao.entities.CatTipoLlamada;
import co.com.tactusoft.dialer.mapper.AgentRowMapper;
import co.com.tactusoft.dialer.mapper.AstTrunkDialpatternsRowMapper;
import co.com.tactusoft.dialer.mapper.CatTipoLlamadaRowMapper;

@Component("iDao")
public class DaoImpl<T extends Serializable> implements IDao<T> {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(
			@Qualifier("dataSourceDefault") DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Transactional
	public List<CatTipoLlamada> getListCatTipoLlamada() {
		return jdbcTemplate
				.query("SELECT [id_TipoLlamada],[tipo_llamada] FROM [cat_TipoLlamada]",
						new Object[] {}, new CatTipoLlamadaRowMapper());
	}

	@Override
	@Transactional
	public List<Agent> getListAgent() {
		return jdbcTemplate.query("SELECT ag.number as agent, (  "
				+ "select count(0) from audit au, break br "
				+ "where au.id_break = br.id and au.id_agent = ag.id "
				+ "and ucase(br.name)= 'LLAMADA' and au.duration is null "
				+ "and au.datetime_init > CURDATE()) as ready_for_call "
				+ "FROM agent ag", new Object[] {}, new AgentRowMapper());
	}
	
	@Override
	@Transactional
	public List<AstTrunkDialpatterns> getListRegularExpression() {
		return jdbcTemplate
				.query("SELECT c.trunkid AS trunkid, "
						+ "REPLACE(REPLACE(concat(a.match_pattern_prefix, a.match_pattern_pass),_latin1'X',_latin1'\\d'),_latin1'N',_latin1'\\d') AS expression_regular, "
						+ "concat(ucase(c.tech),_latin1'/',c.channelid,_latin1'/numero_a_marcar') AS call_number,  "
						+ "(CASE WHEN (locate('Lyric',c.channelid) > 0) THEN 0 else 1 end) AS prefix  "
						+ "FROM ((asterisk.outbound_route_patterns a JOIN asterisk.outbound_route_trunks b) JOIN asterisk.trunks c)  "
						+ "WHERE ((a.route_id = b.route_id) and (b.seq = 0)  "
						+ "	AND (b.trunk_id = c.trunkid) "
						+ "	AND (locate(_latin1'd',replace(replace(concat(a.match_pattern_prefix,a.match_pattern_pass),_latin1'X',_latin1'\\d'),_latin1'N',_latin1'\\d')) > 0))",
						new Object[] {}, new AstTrunkDialpatternsRowMapper());
	}

}
