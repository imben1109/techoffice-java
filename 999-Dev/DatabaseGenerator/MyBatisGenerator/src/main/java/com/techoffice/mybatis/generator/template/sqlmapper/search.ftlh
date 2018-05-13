	<select id="search" resultMap="${uncaptialJavaClassName}ResultMap">
		SELECT * FROM TEST 
		WHERE 1=1
		<include refid="${uncaptialJavaClassName}Criteria"></include>
	</select>