<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<label for="v44-1" title="v44">metrum típus</label>
<table id="v44" class="fields">
	<tr id="v44-1" class="unit">
		<td class="inputs">
			<select name="v44[]" style="width: 200px;">
				<option value="">-- [ válasszon! ] --</option>
				<option value="1">Szótagszámláló, izostrofikus vers</option>
				<option value="3">Bizonytalan, hogy vers-e, vagy próza</option>
				<option value="4">Bizonytalan verselésű időmértékes vers</option>
				<option value="5">Bizonytalan verselésű szótagszámláló, izostrofikus vers</option>
				<option value="6">Hexameter</option>
				<option value="7">Disztichon</option>
				<option value="8">Időmértékes vers, de nem hexameter vagy disztichon</option>
				<option value="10">Hangsúlyos, nem strofikus, nem szótagszámláló rímtelen vers</option>
				<option value="11">Bizonytalan, hogy vers-e, vagy ritmikus próza</option>
				<option value="12">Verssorok és próza váltakozása</option>
				<option value="15">Váltakozó metrumú (ld. a Mellékadatlapok leírásánál!)</option>
				<option value="16">Pesti Gábor-féle metrum</option>
				<option value="17">Szótagszámláló vers</option>
				<option value="18">Szószámláló vers</option>
				<option value="19">Sequentiát imitáló vers</option>
				<option value="30">Nótajelzés (metruma más vers metruma alapján van kikövetkeztetve)</option>
			</select>
		</td>
<%@ include file="/form/row_controll.jsp" %>
	</tr>
</table>
