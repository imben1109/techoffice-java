# Docx4j - Extract Content Example

## Example 

Sample Code
```
WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(file);
MainDocumentPart documentPart = wordMLPackage.getMainDocumentPart();
StringWriter stringWriter = new StringWriter();
TextUtils.extractText(documentPart.getContents(), stringWriter);
stringWriter.close();
String content = stringWriter.toString();
return content;
```

## Microsoft Word Open XML Format

Empty Paragraph
```
<w:p w:rsidR="002A6479" w:rsidRDefault="002A6479"/>
```

Text Paragraph
```
<w:p w:rsidR="002A6479" w:rsidRDefault="00502E17">
	<w:r>
		<w:rPr><w:rFonts w:hint="eastAsia"/></w:rPr>
		<w:t>Paragraph</w:t>
	</w:r>
</w:p>
```

Title
```
<w:p w:rsidR="00B63BA2" w:rsidRDefault="00B63BA2" w:rsidP="00B63BA2">
	<w:pPr><w:pStyle w:val="1"/><w:rPr><w:rFonts w:hint="eastAsia"/></w:rPr></w:pPr>
	<w:r>
		<w:rPr><w:rFonts w:hint="eastAsia"/></w:rPr>
		<w:t>Title 1</w:t>
	</w:r>
</w:p>
<w:p w:rsidR="00B63BA2" w:rsidRDefault="00B63BA2" w:rsidP="00B63BA2">
	<w:pPr><w:pStyle w:val="2"/><w:rPr><w:rFonts w:hint="eastAsia"/></w:rPr></w:pPr>
	<w:r>
		<w:rPr><w:rFonts w:hint="eastAsia"/></w:rPr>
		<w:t>Title 2</w:t>
	</w:r>
</w:p>
```

List 
```
<w:p w:rsidR="002D3CE7" w:rsidRDefault="002D3CE7" w:rsidP="002D3CE7">
	<w:pPr>
		<w:pStyle w:val="a8"/>
		<w:numPr>
			<w:ilvl w:val="0"/>
			<w:numId w:val="1"/>
		</w:numPr>
		<w:ind w:leftChars="0"/>
		<w:rPr><w:rFonts w:hint="eastAsia"/></w:rPr>
	</w:pPr>
	<w:r>
		<w:rPr><w:rFonts w:hint="eastAsia"/></w:rPr>
		<w:t>List 1</w:t>
	</w:r>
</w:p>
```

Table
```
<w:tbl>
	<w:tblPr><w:tblStyle w:val="a7"/><w:tblW w:w="0" w:type="auto"/><w:tblLook w:val="04A0"/></w:tblPr><w:tblGrid><w:gridCol w:w="4181"/><w:gridCol w:w="4181"/></w:tblGrid>
	<w:tr w:rsidR="006B162E" w:rsidTr="006B162E">
		<w:tc>
			<w:tcPr><w:tcW w:w="4181" w:type="dxa"/></w:tcPr>
			<w:p w:rsidR="006B162E" w:rsidRDefault="006B162E" w:rsidP="00B63BA2">
				<w:r>
					<w:rPr><w:rFonts w:hint="eastAsia"/></w:rPr>
					<w:t>Table 1</w:t>
				</w:r>
			</w:p>
		</w:tc>
		<w:tc>
			<w:tcPr><w:tcW w:w="4181" w:type="dxa"/></w:tcPr>
			<w:p w:rsidR="006B162E" w:rsidRDefault="006B162E" w:rsidP="00B63BA2">
				<w:r>
					<w:rPr><w:rFonts w:hint="eastAsia"/></w:rPr>
					<w:t>Table 1</w:t>
				</w:r>
			</w:p>
		</w:tc>
	</w:tr>
	<w:tr w:rsidR="006B162E" w:rsidTr="006B162E">
		<w:tc>
			<w:tcPr><w:tcW w:w="4181" w:type="dxa"/></w:tcPr>
			<w:p w:rsidR="006B162E" w:rsidRDefault="006B162E" w:rsidP="00B63BA2">
				<w:r>
					<w:rPr><w:rFonts w:hint="eastAsia"/></w:rPr>
					<w:t>Table 1</w:t>
				</w:r>
			</w:p>
		</w:tc>
		<w:tc>
			<w:tcPr><w:tcW w:w="4181" w:type="dxa"/></w:tcPr>
			<w:p w:rsidR="006B162E" w:rsidRDefault="006B162E" w:rsidP="00B63BA2">
				<w:r>
					<w:rPr><w:rFonts w:hint="eastAsia"/></w:rPr>
					<w:t>Table 1</w:t>
				</w:r>
			</w:p>
		</w:tc>
	</w:tr>
</w:tbl>
```