package spring.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import spring.entity.ItemDto;

public class ItemDaoImpl implements ItemDao {
	// JdbcTemplate ½½·Ô
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private RowMapper<ItemDto> mapper = new RowMapper<ItemDto>() {
		@Override
		public ItemDto mapRow(ResultSet rs, int index) throws SQLException {
			ItemDto itemDto = ItemDto.builder().no(rs.getInt("no")).name(rs.getString("name"))
					.type(rs.getString("type"))
					.price(rs.getInt("price"))
					.build();
			return itemDto;
		}
	};

	@Override
	public void insert(ItemDto dto) {
		String sql = "insert into Item values(Item_seq.nextval,?,?,?)";
		Object[] param = new Object[] { dto.getName(), dto.getType(), dto.getPrice() };
		jdbcTemplate.update(sql, param);

	}

	@Override
	public List<ItemDto> list() {
		String sql = "select * from Item order by no";
		return jdbcTemplate.query(sql, mapper);
	}

	@Override
	public List<ItemDto> get(int no) {
		String sql = "select * from Item where = no";
		Object[] param = { no };
		return jdbcTemplate.query(sql, param, mapper);
	}

}
