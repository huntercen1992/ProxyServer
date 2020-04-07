package com.hunter.proxy.proxyServer.Encryption;

import java.util.HashMap;
import java.util.Random;

public class EncryptUtil {

	private static byte[] keys = {57, 22, -91, 82, -76, -126, -107, -28, 74, -96, 30, -51, 121, -92, -39, 45, -128, -10, 122, 86, -112, 105, -73, -87, 95, 5, 90,
								 87, -36, -67, -118, -44, -69, 72, 51, 78, 16, -83, -56, -35, -71, -85, 7, -121, 113, -123, 49, 116, 19, 18, 110, 75, -57, 55, -30,
								 85, -109, 70, -23, -120, 50, -119, -89, -99, 39, -12, -32, -115, -38, 59, 79, -17, 115, 0, 114, -43, 33, -9, 17, -106, -53, -65,
								 -75, 65, -81, -66, 29, 60, -16, 63, -90, 107, -34, 112, -2, 126, -127, -54, 14, -41, 125, -47, 104, 69, 34, 31, -62, 97, 73, 124,
								 -113, 10, 36, 98, 84, 2, 93, -55, 9, -45, -105, 13, 123, -48, 1, -5, -86, 44, -15, -74, 111, 108, 64, -13, 58, 118, 66, -18, 56,
								 25, 127, -124, 41, -78, 53, -111, 38, 21, 6, 40, 120, -68, 76, -116, 12, -79, -31, -14, -24, -49, -104, -95, 81, -125, -114, -27,
								 -64, 92, 91, -11, 77, -108, 43, -98, 37, 119, -77, 8, -40, -94, 62, 3, 47, 61, -58, -61, 68, -29, -46, 96, -101, 102, -82, 80, 42,
								 -103, -117, -20, -7, -21, 24, 89, 83, -122, -70, -8, 26, 20, 100, 15, 27, -19, 101, 99, 28, -110, 11, -42, 54, -50, 35, -4, 106,
								 46, -60, -88, 103, -97, -80, -37, -52, -84, 94, 52, -6, 4, -93, 109, 71, 117, -59, -72, -102, 48, -25, -22, 88, 32, -63, -100, 23,
								 -1, -3, -33, -26, 67};
	
	private static final boolean flag = false;
	
	private static final HashMap<Byte, Byte> encrypMap = new HashMap<Byte, Byte>();
	private static final HashMap<Byte, Byte> decrypMap = new HashMap<Byte, Byte>();
	
	static{
		encrypMap.put(new Integer(-128).byteValue(), keys[0]);
		encrypMap.put(new Integer(-127).byteValue(), keys[1]);
		encrypMap.put(new Integer(-126).byteValue(), keys[2]);
		encrypMap.put(new Integer(-125).byteValue(), keys[3]);
		encrypMap.put(new Integer(-124).byteValue(), keys[4]);
		encrypMap.put(new Integer(-123).byteValue(), keys[5]);
		encrypMap.put(new Integer(-122).byteValue(), keys[6]);
		encrypMap.put(new Integer(-121).byteValue(), keys[7]);
		encrypMap.put(new Integer(-120).byteValue(), keys[8]);
		encrypMap.put(new Integer(-119).byteValue(), keys[9]);
		encrypMap.put(new Integer(-118).byteValue(), keys[10]);
		encrypMap.put(new Integer(-117).byteValue(), keys[11]);
		encrypMap.put(new Integer(-116).byteValue(), keys[12]);
		encrypMap.put(new Integer(-115).byteValue(), keys[13]);
		encrypMap.put(new Integer(-114).byteValue(), keys[14]);
		encrypMap.put(new Integer(-113).byteValue(), keys[15]);
		encrypMap.put(new Integer(-112).byteValue(), keys[16]);
		encrypMap.put(new Integer(-111).byteValue(), keys[17]);
		encrypMap.put(new Integer(-110).byteValue(), keys[18]);
		encrypMap.put(new Integer(-109).byteValue(), keys[19]);
		encrypMap.put(new Integer(-108).byteValue(), keys[20]);
		encrypMap.put(new Integer(-107).byteValue(), keys[21]);
		encrypMap.put(new Integer(-106).byteValue(), keys[22]);
		encrypMap.put(new Integer(-105).byteValue(), keys[23]);
		encrypMap.put(new Integer(-104).byteValue(), keys[24]);
		encrypMap.put(new Integer(-103).byteValue(), keys[25]);
		encrypMap.put(new Integer(-102).byteValue(), keys[26]);
		encrypMap.put(new Integer(-101).byteValue(), keys[27]);
		encrypMap.put(new Integer(-100).byteValue(), keys[28]);
		encrypMap.put(new Integer(-99).byteValue(), keys[29]);
		encrypMap.put(new Integer(-98).byteValue(), keys[30]);
		encrypMap.put(new Integer(-97).byteValue(), keys[31]);
		encrypMap.put(new Integer(-96).byteValue(), keys[32]);
		encrypMap.put(new Integer(-95).byteValue(), keys[33]);
		encrypMap.put(new Integer(-94).byteValue(), keys[34]);
		encrypMap.put(new Integer(-93).byteValue(), keys[35]);
		encrypMap.put(new Integer(-92).byteValue(), keys[36]);
		encrypMap.put(new Integer(-91).byteValue(), keys[37]);
		encrypMap.put(new Integer(-90).byteValue(), keys[38]);
		encrypMap.put(new Integer(-89).byteValue(), keys[39]);
		encrypMap.put(new Integer(-88).byteValue(), keys[40]);
		encrypMap.put(new Integer(-87).byteValue(), keys[41]);
		encrypMap.put(new Integer(-86).byteValue(), keys[42]);
		encrypMap.put(new Integer(-85).byteValue(), keys[43]);
		encrypMap.put(new Integer(-84).byteValue(), keys[44]);
		encrypMap.put(new Integer(-83).byteValue(), keys[45]);
		encrypMap.put(new Integer(-82).byteValue(), keys[46]);
		encrypMap.put(new Integer(-81).byteValue(), keys[47]);
		encrypMap.put(new Integer(-80).byteValue(), keys[48]);
		encrypMap.put(new Integer(-79).byteValue(), keys[49]);
		encrypMap.put(new Integer(-78).byteValue(), keys[50]);
		encrypMap.put(new Integer(-77).byteValue(), keys[51]);
		encrypMap.put(new Integer(-76).byteValue(), keys[52]);
		encrypMap.put(new Integer(-75).byteValue(), keys[53]);
		encrypMap.put(new Integer(-74).byteValue(), keys[54]);
		encrypMap.put(new Integer(-73).byteValue(), keys[55]);
		encrypMap.put(new Integer(-72).byteValue(), keys[56]);
		encrypMap.put(new Integer(-71).byteValue(), keys[57]);
		encrypMap.put(new Integer(-70).byteValue(), keys[58]);
		encrypMap.put(new Integer(-69).byteValue(), keys[59]);
		encrypMap.put(new Integer(-68).byteValue(), keys[60]);
		encrypMap.put(new Integer(-67).byteValue(), keys[61]);
		encrypMap.put(new Integer(-66).byteValue(), keys[62]);
		encrypMap.put(new Integer(-65).byteValue(), keys[63]);
		encrypMap.put(new Integer(-64).byteValue(), keys[64]);
		encrypMap.put(new Integer(-63).byteValue(), keys[65]);
		encrypMap.put(new Integer(-62).byteValue(), keys[66]);
		encrypMap.put(new Integer(-61).byteValue(), keys[67]);
		encrypMap.put(new Integer(-60).byteValue(), keys[68]);
		encrypMap.put(new Integer(-59).byteValue(), keys[69]);
		encrypMap.put(new Integer(-58).byteValue(), keys[70]);
		encrypMap.put(new Integer(-57).byteValue(), keys[71]);
		encrypMap.put(new Integer(-56).byteValue(), keys[72]);
		encrypMap.put(new Integer(-55).byteValue(), keys[73]);
		encrypMap.put(new Integer(-54).byteValue(), keys[74]);
		encrypMap.put(new Integer(-53).byteValue(), keys[75]);
		encrypMap.put(new Integer(-52).byteValue(), keys[76]);
		encrypMap.put(new Integer(-51).byteValue(), keys[77]);
		encrypMap.put(new Integer(-50).byteValue(), keys[78]);
		encrypMap.put(new Integer(-49).byteValue(), keys[79]);
		encrypMap.put(new Integer(-48).byteValue(), keys[80]);
		encrypMap.put(new Integer(-47).byteValue(), keys[81]);
		encrypMap.put(new Integer(-46).byteValue(), keys[82]);
		encrypMap.put(new Integer(-45).byteValue(), keys[83]);
		encrypMap.put(new Integer(-44).byteValue(), keys[84]);
		encrypMap.put(new Integer(-43).byteValue(), keys[85]);
		encrypMap.put(new Integer(-42).byteValue(), keys[86]);
		encrypMap.put(new Integer(-41).byteValue(), keys[87]);
		encrypMap.put(new Integer(-40).byteValue(), keys[88]);
		encrypMap.put(new Integer(-39).byteValue(), keys[89]);
		encrypMap.put(new Integer(-38).byteValue(), keys[90]);
		encrypMap.put(new Integer(-37).byteValue(), keys[91]);
		encrypMap.put(new Integer(-36).byteValue(), keys[92]);
		encrypMap.put(new Integer(-35).byteValue(), keys[93]);
		encrypMap.put(new Integer(-34).byteValue(), keys[94]);
		encrypMap.put(new Integer(-33).byteValue(), keys[95]);
		encrypMap.put(new Integer(-32).byteValue(), keys[96]);
		encrypMap.put(new Integer(-31).byteValue(), keys[97]);
		encrypMap.put(new Integer(-30).byteValue(), keys[98]);
		encrypMap.put(new Integer(-29).byteValue(), keys[99]);
		encrypMap.put(new Integer(-28).byteValue(), keys[100]);
		encrypMap.put(new Integer(-27).byteValue(), keys[101]);
		encrypMap.put(new Integer(-26).byteValue(), keys[102]);
		encrypMap.put(new Integer(-25).byteValue(), keys[103]);
		encrypMap.put(new Integer(-24).byteValue(), keys[104]);
		encrypMap.put(new Integer(-23).byteValue(), keys[105]);
		encrypMap.put(new Integer(-22).byteValue(), keys[106]);
		encrypMap.put(new Integer(-21).byteValue(), keys[107]);
		encrypMap.put(new Integer(-20).byteValue(), keys[108]);
		encrypMap.put(new Integer(-19).byteValue(), keys[109]);
		encrypMap.put(new Integer(-18).byteValue(), keys[110]);
		encrypMap.put(new Integer(-17).byteValue(), keys[111]);
		encrypMap.put(new Integer(-16).byteValue(), keys[112]);
		encrypMap.put(new Integer(-15).byteValue(), keys[113]);
		encrypMap.put(new Integer(-14).byteValue(), keys[114]);
		encrypMap.put(new Integer(-13).byteValue(), keys[115]);
		encrypMap.put(new Integer(-12).byteValue(), keys[116]);
		encrypMap.put(new Integer(-11).byteValue(), keys[117]);
		encrypMap.put(new Integer(-10).byteValue(), keys[118]);
		encrypMap.put(new Integer(-9).byteValue(), keys[119]);
		encrypMap.put(new Integer(-8).byteValue(), keys[120]);
		encrypMap.put(new Integer(-7).byteValue(), keys[121]);
		encrypMap.put(new Integer(-6).byteValue(), keys[122]);
		encrypMap.put(new Integer(-5).byteValue(), keys[123]);
		encrypMap.put(new Integer(-4).byteValue(), keys[124]);
		encrypMap.put(new Integer(-3).byteValue(), keys[125]);
		encrypMap.put(new Integer(-2).byteValue(), keys[126]);
		encrypMap.put(new Integer(-1).byteValue(), keys[127]);
		encrypMap.put(new Integer(0).byteValue(), keys[128]);
		encrypMap.put(new Integer(1).byteValue(), keys[129]);
		encrypMap.put(new Integer(2).byteValue(), keys[130]);
		encrypMap.put(new Integer(3).byteValue(), keys[131]);
		encrypMap.put(new Integer(4).byteValue(), keys[132]);
		encrypMap.put(new Integer(5).byteValue(), keys[133]);
		encrypMap.put(new Integer(6).byteValue(), keys[134]);
		encrypMap.put(new Integer(7).byteValue(), keys[135]);
		encrypMap.put(new Integer(8).byteValue(), keys[136]);
		encrypMap.put(new Integer(9).byteValue(), keys[137]);
		encrypMap.put(new Integer(10).byteValue(), keys[138]);
		encrypMap.put(new Integer(11).byteValue(), keys[139]);
		encrypMap.put(new Integer(12).byteValue(), keys[140]);
		encrypMap.put(new Integer(13).byteValue(), keys[141]);
		encrypMap.put(new Integer(14).byteValue(), keys[142]);
		encrypMap.put(new Integer(15).byteValue(), keys[143]);
		encrypMap.put(new Integer(16).byteValue(), keys[144]);
		encrypMap.put(new Integer(17).byteValue(), keys[145]);
		encrypMap.put(new Integer(18).byteValue(), keys[146]);
		encrypMap.put(new Integer(19).byteValue(), keys[147]);
		encrypMap.put(new Integer(20).byteValue(), keys[148]);
		encrypMap.put(new Integer(21).byteValue(), keys[149]);
		encrypMap.put(new Integer(22).byteValue(), keys[150]);
		encrypMap.put(new Integer(23).byteValue(), keys[151]);
		encrypMap.put(new Integer(24).byteValue(), keys[152]);
		encrypMap.put(new Integer(25).byteValue(), keys[153]);
		encrypMap.put(new Integer(26).byteValue(), keys[154]);
		encrypMap.put(new Integer(27).byteValue(), keys[155]);
		encrypMap.put(new Integer(28).byteValue(), keys[156]);
		encrypMap.put(new Integer(29).byteValue(), keys[157]);
		encrypMap.put(new Integer(30).byteValue(), keys[158]);
		encrypMap.put(new Integer(31).byteValue(), keys[159]);
		encrypMap.put(new Integer(32).byteValue(), keys[160]);
		encrypMap.put(new Integer(33).byteValue(), keys[161]);
		encrypMap.put(new Integer(34).byteValue(), keys[162]);
		encrypMap.put(new Integer(35).byteValue(), keys[163]);
		encrypMap.put(new Integer(36).byteValue(), keys[164]);
		encrypMap.put(new Integer(37).byteValue(), keys[165]);
		encrypMap.put(new Integer(38).byteValue(), keys[166]);
		encrypMap.put(new Integer(39).byteValue(), keys[167]);
		encrypMap.put(new Integer(40).byteValue(), keys[168]);
		encrypMap.put(new Integer(41).byteValue(), keys[169]);
		encrypMap.put(new Integer(42).byteValue(), keys[170]);
		encrypMap.put(new Integer(43).byteValue(), keys[171]);
		encrypMap.put(new Integer(44).byteValue(), keys[172]);
		encrypMap.put(new Integer(45).byteValue(), keys[173]);
		encrypMap.put(new Integer(46).byteValue(), keys[174]);
		encrypMap.put(new Integer(47).byteValue(), keys[175]);
		encrypMap.put(new Integer(48).byteValue(), keys[176]);
		encrypMap.put(new Integer(49).byteValue(), keys[177]);
		encrypMap.put(new Integer(50).byteValue(), keys[178]);
		encrypMap.put(new Integer(51).byteValue(), keys[179]);
		encrypMap.put(new Integer(52).byteValue(), keys[180]);
		encrypMap.put(new Integer(53).byteValue(), keys[181]);
		encrypMap.put(new Integer(54).byteValue(), keys[182]);
		encrypMap.put(new Integer(55).byteValue(), keys[183]);
		encrypMap.put(new Integer(56).byteValue(), keys[184]);
		encrypMap.put(new Integer(57).byteValue(), keys[185]);
		encrypMap.put(new Integer(58).byteValue(), keys[186]);
		encrypMap.put(new Integer(59).byteValue(), keys[187]);
		encrypMap.put(new Integer(60).byteValue(), keys[188]);
		encrypMap.put(new Integer(61).byteValue(), keys[189]);
		encrypMap.put(new Integer(62).byteValue(), keys[190]);
		encrypMap.put(new Integer(63).byteValue(), keys[191]);
		encrypMap.put(new Integer(64).byteValue(), keys[192]);
		encrypMap.put(new Integer(65).byteValue(), keys[193]);
		encrypMap.put(new Integer(66).byteValue(), keys[194]);
		encrypMap.put(new Integer(67).byteValue(), keys[195]);
		encrypMap.put(new Integer(68).byteValue(), keys[196]);
		encrypMap.put(new Integer(69).byteValue(), keys[197]);
		encrypMap.put(new Integer(70).byteValue(), keys[198]);
		encrypMap.put(new Integer(71).byteValue(), keys[199]);
		encrypMap.put(new Integer(72).byteValue(), keys[200]);
		encrypMap.put(new Integer(73).byteValue(), keys[201]);
		encrypMap.put(new Integer(74).byteValue(), keys[202]);
		encrypMap.put(new Integer(75).byteValue(), keys[203]);
		encrypMap.put(new Integer(76).byteValue(), keys[204]);
		encrypMap.put(new Integer(77).byteValue(), keys[205]);
		encrypMap.put(new Integer(78).byteValue(), keys[206]);
		encrypMap.put(new Integer(79).byteValue(), keys[207]);
		encrypMap.put(new Integer(80).byteValue(), keys[208]);
		encrypMap.put(new Integer(81).byteValue(), keys[209]);
		encrypMap.put(new Integer(82).byteValue(), keys[210]);
		encrypMap.put(new Integer(83).byteValue(), keys[211]);
		encrypMap.put(new Integer(84).byteValue(), keys[212]);
		encrypMap.put(new Integer(85).byteValue(), keys[213]);
		encrypMap.put(new Integer(86).byteValue(), keys[214]);
		encrypMap.put(new Integer(87).byteValue(), keys[215]);
		encrypMap.put(new Integer(88).byteValue(), keys[216]);
		encrypMap.put(new Integer(89).byteValue(), keys[217]);
		encrypMap.put(new Integer(90).byteValue(), keys[218]);
		encrypMap.put(new Integer(91).byteValue(), keys[219]);
		encrypMap.put(new Integer(92).byteValue(), keys[220]);
		encrypMap.put(new Integer(93).byteValue(), keys[221]);
		encrypMap.put(new Integer(94).byteValue(), keys[222]);
		encrypMap.put(new Integer(95).byteValue(), keys[223]);
		encrypMap.put(new Integer(96).byteValue(), keys[224]);
		encrypMap.put(new Integer(97).byteValue(), keys[225]);
		encrypMap.put(new Integer(98).byteValue(), keys[226]);
		encrypMap.put(new Integer(99).byteValue(), keys[227]);
		encrypMap.put(new Integer(100).byteValue(), keys[228]);
		encrypMap.put(new Integer(101).byteValue(), keys[229]);
		encrypMap.put(new Integer(102).byteValue(), keys[230]);
		encrypMap.put(new Integer(103).byteValue(), keys[231]);
		encrypMap.put(new Integer(104).byteValue(), keys[232]);
		encrypMap.put(new Integer(105).byteValue(), keys[233]);
		encrypMap.put(new Integer(106).byteValue(), keys[234]);
		encrypMap.put(new Integer(107).byteValue(), keys[235]);
		encrypMap.put(new Integer(108).byteValue(), keys[236]);
		encrypMap.put(new Integer(109).byteValue(), keys[237]);
		encrypMap.put(new Integer(110).byteValue(), keys[238]);
		encrypMap.put(new Integer(111).byteValue(), keys[239]);
		encrypMap.put(new Integer(112).byteValue(), keys[240]);
		encrypMap.put(new Integer(113).byteValue(), keys[241]);
		encrypMap.put(new Integer(114).byteValue(), keys[242]);
		encrypMap.put(new Integer(115).byteValue(), keys[243]);
		encrypMap.put(new Integer(116).byteValue(), keys[244]);
		encrypMap.put(new Integer(117).byteValue(), keys[245]);
		encrypMap.put(new Integer(118).byteValue(), keys[246]);
		encrypMap.put(new Integer(119).byteValue(), keys[247]);
		encrypMap.put(new Integer(120).byteValue(), keys[248]);
		encrypMap.put(new Integer(121).byteValue(), keys[249]);
		encrypMap.put(new Integer(122).byteValue(), keys[250]);
		encrypMap.put(new Integer(123).byteValue(), keys[251]);
		encrypMap.put(new Integer(124).byteValue(), keys[252]);
		encrypMap.put(new Integer(125).byteValue(), keys[253]);
		encrypMap.put(new Integer(126).byteValue(), keys[254]);
		encrypMap.put(new Integer(127).byteValue(), keys[255]);

		
		decrypMap.put(keys[0], new Integer(-128).byteValue());
		decrypMap.put(keys[1], new Integer(-127).byteValue());
		decrypMap.put(keys[2], new Integer(-126).byteValue());
		decrypMap.put(keys[3], new Integer(-125).byteValue());
		decrypMap.put(keys[4], new Integer(-124).byteValue());
		decrypMap.put(keys[5], new Integer(-123).byteValue());
		decrypMap.put(keys[6], new Integer(-122).byteValue());
		decrypMap.put(keys[7], new Integer(-121).byteValue());
		decrypMap.put(keys[8], new Integer(-120).byteValue());
		decrypMap.put(keys[9], new Integer(-119).byteValue());
		decrypMap.put(keys[10], new Integer(-118).byteValue());
		decrypMap.put(keys[11], new Integer(-117).byteValue());
		decrypMap.put(keys[12], new Integer(-116).byteValue());
		decrypMap.put(keys[13], new Integer(-115).byteValue());
		decrypMap.put(keys[14], new Integer(-114).byteValue());
		decrypMap.put(keys[15], new Integer(-113).byteValue());
		decrypMap.put(keys[16], new Integer(-112).byteValue());
		decrypMap.put(keys[17], new Integer(-111).byteValue());
		decrypMap.put(keys[18], new Integer(-110).byteValue());
		decrypMap.put(keys[19], new Integer(-109).byteValue());
		decrypMap.put(keys[20], new Integer(-108).byteValue());
		decrypMap.put(keys[21], new Integer(-107).byteValue());
		decrypMap.put(keys[22], new Integer(-106).byteValue());
		decrypMap.put(keys[23], new Integer(-105).byteValue());
		decrypMap.put(keys[24], new Integer(-104).byteValue());
		decrypMap.put(keys[25], new Integer(-103).byteValue());
		decrypMap.put(keys[26], new Integer(-102).byteValue());
		decrypMap.put(keys[27], new Integer(-101).byteValue());
		decrypMap.put(keys[28], new Integer(-100).byteValue());
		decrypMap.put(keys[29], new Integer(-99).byteValue());
		decrypMap.put(keys[30], new Integer(-98).byteValue());
		decrypMap.put(keys[31], new Integer(-97).byteValue());
		decrypMap.put(keys[32], new Integer(-96).byteValue());
		decrypMap.put(keys[33], new Integer(-95).byteValue());
		decrypMap.put(keys[34], new Integer(-94).byteValue());
		decrypMap.put(keys[35], new Integer(-93).byteValue());
		decrypMap.put(keys[36], new Integer(-92).byteValue());
		decrypMap.put(keys[37], new Integer(-91).byteValue());
		decrypMap.put(keys[38], new Integer(-90).byteValue());
		decrypMap.put(keys[39], new Integer(-89).byteValue());
		decrypMap.put(keys[40], new Integer(-88).byteValue());
		decrypMap.put(keys[41], new Integer(-87).byteValue());
		decrypMap.put(keys[42], new Integer(-86).byteValue());
		decrypMap.put(keys[43], new Integer(-85).byteValue());
		decrypMap.put(keys[44], new Integer(-84).byteValue());
		decrypMap.put(keys[45], new Integer(-83).byteValue());
		decrypMap.put(keys[46], new Integer(-82).byteValue());
		decrypMap.put(keys[47], new Integer(-81).byteValue());
		decrypMap.put(keys[48], new Integer(-80).byteValue());
		decrypMap.put(keys[49], new Integer(-79).byteValue());
		decrypMap.put(keys[50], new Integer(-78).byteValue());
		decrypMap.put(keys[51], new Integer(-77).byteValue());
		decrypMap.put(keys[52], new Integer(-76).byteValue());
		decrypMap.put(keys[53], new Integer(-75).byteValue());
		decrypMap.put(keys[54], new Integer(-74).byteValue());
		decrypMap.put(keys[55], new Integer(-73).byteValue());
		decrypMap.put(keys[56], new Integer(-72).byteValue());
		decrypMap.put(keys[57], new Integer(-71).byteValue());
		decrypMap.put(keys[58], new Integer(-70).byteValue());
		decrypMap.put(keys[59], new Integer(-69).byteValue());
		decrypMap.put(keys[60], new Integer(-68).byteValue());
		decrypMap.put(keys[61], new Integer(-67).byteValue());
		decrypMap.put(keys[62], new Integer(-66).byteValue());
		decrypMap.put(keys[63], new Integer(-65).byteValue());
		decrypMap.put(keys[64], new Integer(-64).byteValue());
		decrypMap.put(keys[65], new Integer(-63).byteValue());
		decrypMap.put(keys[66], new Integer(-62).byteValue());
		decrypMap.put(keys[67], new Integer(-61).byteValue());
		decrypMap.put(keys[68], new Integer(-60).byteValue());
		decrypMap.put(keys[69], new Integer(-59).byteValue());
		decrypMap.put(keys[70], new Integer(-58).byteValue());
		decrypMap.put(keys[71], new Integer(-57).byteValue());
		decrypMap.put(keys[72], new Integer(-56).byteValue());
		decrypMap.put(keys[73], new Integer(-55).byteValue());
		decrypMap.put(keys[74], new Integer(-54).byteValue());
		decrypMap.put(keys[75], new Integer(-53).byteValue());
		decrypMap.put(keys[76], new Integer(-52).byteValue());
		decrypMap.put(keys[77], new Integer(-51).byteValue());
		decrypMap.put(keys[78], new Integer(-50).byteValue());
		decrypMap.put(keys[79], new Integer(-49).byteValue());
		decrypMap.put(keys[80], new Integer(-48).byteValue());
		decrypMap.put(keys[81], new Integer(-47).byteValue());
		decrypMap.put(keys[82], new Integer(-46).byteValue());
		decrypMap.put(keys[83], new Integer(-45).byteValue());
		decrypMap.put(keys[84], new Integer(-44).byteValue());
		decrypMap.put(keys[85], new Integer(-43).byteValue());
		decrypMap.put(keys[86], new Integer(-42).byteValue());
		decrypMap.put(keys[87], new Integer(-41).byteValue());
		decrypMap.put(keys[88], new Integer(-40).byteValue());
		decrypMap.put(keys[89], new Integer(-39).byteValue());
		decrypMap.put(keys[90], new Integer(-38).byteValue());
		decrypMap.put(keys[91], new Integer(-37).byteValue());
		decrypMap.put(keys[92], new Integer(-36).byteValue());
		decrypMap.put(keys[93], new Integer(-35).byteValue());
		decrypMap.put(keys[94], new Integer(-34).byteValue());
		decrypMap.put(keys[95], new Integer(-33).byteValue());
		decrypMap.put(keys[96], new Integer(-32).byteValue());
		decrypMap.put(keys[97], new Integer(-31).byteValue());
		decrypMap.put(keys[98], new Integer(-30).byteValue());
		decrypMap.put(keys[99], new Integer(-29).byteValue());
		decrypMap.put(keys[100], new Integer(-28).byteValue());
		decrypMap.put(keys[101], new Integer(-27).byteValue());
		decrypMap.put(keys[102], new Integer(-26).byteValue());
		decrypMap.put(keys[103], new Integer(-25).byteValue());
		decrypMap.put(keys[104], new Integer(-24).byteValue());
		decrypMap.put(keys[105], new Integer(-23).byteValue());
		decrypMap.put(keys[106], new Integer(-22).byteValue());
		decrypMap.put(keys[107], new Integer(-21).byteValue());
		decrypMap.put(keys[108], new Integer(-20).byteValue());
		decrypMap.put(keys[109], new Integer(-19).byteValue());
		decrypMap.put(keys[110], new Integer(-18).byteValue());
		decrypMap.put(keys[111], new Integer(-17).byteValue());
		decrypMap.put(keys[112], new Integer(-16).byteValue());
		decrypMap.put(keys[113], new Integer(-15).byteValue());
		decrypMap.put(keys[114], new Integer(-14).byteValue());
		decrypMap.put(keys[115], new Integer(-13).byteValue());
		decrypMap.put(keys[116], new Integer(-12).byteValue());
		decrypMap.put(keys[117], new Integer(-11).byteValue());
		decrypMap.put(keys[118], new Integer(-10).byteValue());
		decrypMap.put(keys[119], new Integer(-9).byteValue());
		decrypMap.put(keys[120], new Integer(-8).byteValue());
		decrypMap.put(keys[121], new Integer(-7).byteValue());
		decrypMap.put(keys[122], new Integer(-6).byteValue());
		decrypMap.put(keys[123], new Integer(-5).byteValue());
		decrypMap.put(keys[124], new Integer(-4).byteValue());
		decrypMap.put(keys[125], new Integer(-3).byteValue());
		decrypMap.put(keys[126], new Integer(-2).byteValue());
		decrypMap.put(keys[127], new Integer(-1).byteValue());
		decrypMap.put(keys[128], new Integer(0).byteValue());
		decrypMap.put(keys[129], new Integer(1).byteValue());
		decrypMap.put(keys[130], new Integer(2).byteValue());
		decrypMap.put(keys[131], new Integer(3).byteValue());
		decrypMap.put(keys[132], new Integer(4).byteValue());
		decrypMap.put(keys[133], new Integer(5).byteValue());
		decrypMap.put(keys[134], new Integer(6).byteValue());
		decrypMap.put(keys[135], new Integer(7).byteValue());
		decrypMap.put(keys[136], new Integer(8).byteValue());
		decrypMap.put(keys[137], new Integer(9).byteValue());
		decrypMap.put(keys[138], new Integer(10).byteValue());
		decrypMap.put(keys[139], new Integer(11).byteValue());
		decrypMap.put(keys[140], new Integer(12).byteValue());
		decrypMap.put(keys[141], new Integer(13).byteValue());
		decrypMap.put(keys[142], new Integer(14).byteValue());
		decrypMap.put(keys[143], new Integer(15).byteValue());
		decrypMap.put(keys[144], new Integer(16).byteValue());
		decrypMap.put(keys[145], new Integer(17).byteValue());
		decrypMap.put(keys[146], new Integer(18).byteValue());
		decrypMap.put(keys[147], new Integer(19).byteValue());
		decrypMap.put(keys[148], new Integer(20).byteValue());
		decrypMap.put(keys[149], new Integer(21).byteValue());
		decrypMap.put(keys[150], new Integer(22).byteValue());
		decrypMap.put(keys[151], new Integer(23).byteValue());
		decrypMap.put(keys[152], new Integer(24).byteValue());
		decrypMap.put(keys[153], new Integer(25).byteValue());
		decrypMap.put(keys[154], new Integer(26).byteValue());
		decrypMap.put(keys[155], new Integer(27).byteValue());
		decrypMap.put(keys[156], new Integer(28).byteValue());
		decrypMap.put(keys[157], new Integer(29).byteValue());
		decrypMap.put(keys[158], new Integer(30).byteValue());
		decrypMap.put(keys[159], new Integer(31).byteValue());
		decrypMap.put(keys[160], new Integer(32).byteValue());
		decrypMap.put(keys[161], new Integer(33).byteValue());
		decrypMap.put(keys[162], new Integer(34).byteValue());
		decrypMap.put(keys[163], new Integer(35).byteValue());
		decrypMap.put(keys[164], new Integer(36).byteValue());
		decrypMap.put(keys[165], new Integer(37).byteValue());
		decrypMap.put(keys[166], new Integer(38).byteValue());
		decrypMap.put(keys[167], new Integer(39).byteValue());
		decrypMap.put(keys[168], new Integer(40).byteValue());
		decrypMap.put(keys[169], new Integer(41).byteValue());
		decrypMap.put(keys[170], new Integer(42).byteValue());
		decrypMap.put(keys[171], new Integer(43).byteValue());
		decrypMap.put(keys[172], new Integer(44).byteValue());
		decrypMap.put(keys[173], new Integer(45).byteValue());
		decrypMap.put(keys[174], new Integer(46).byteValue());
		decrypMap.put(keys[175], new Integer(47).byteValue());
		decrypMap.put(keys[176], new Integer(48).byteValue());
		decrypMap.put(keys[177], new Integer(49).byteValue());
		decrypMap.put(keys[178], new Integer(50).byteValue());
		decrypMap.put(keys[179], new Integer(51).byteValue());
		decrypMap.put(keys[180], new Integer(52).byteValue());
		decrypMap.put(keys[181], new Integer(53).byteValue());
		decrypMap.put(keys[182], new Integer(54).byteValue());
		decrypMap.put(keys[183], new Integer(55).byteValue());
		decrypMap.put(keys[184], new Integer(56).byteValue());
		decrypMap.put(keys[185], new Integer(57).byteValue());
		decrypMap.put(keys[186], new Integer(58).byteValue());
		decrypMap.put(keys[187], new Integer(59).byteValue());
		decrypMap.put(keys[188], new Integer(60).byteValue());
		decrypMap.put(keys[189], new Integer(61).byteValue());
		decrypMap.put(keys[190], new Integer(62).byteValue());
		decrypMap.put(keys[191], new Integer(63).byteValue());
		decrypMap.put(keys[192], new Integer(64).byteValue());
		decrypMap.put(keys[193], new Integer(65).byteValue());
		decrypMap.put(keys[194], new Integer(66).byteValue());
		decrypMap.put(keys[195], new Integer(67).byteValue());
		decrypMap.put(keys[196], new Integer(68).byteValue());
		decrypMap.put(keys[197], new Integer(69).byteValue());
		decrypMap.put(keys[198], new Integer(70).byteValue());
		decrypMap.put(keys[199], new Integer(71).byteValue());
		decrypMap.put(keys[200], new Integer(72).byteValue());
		decrypMap.put(keys[201], new Integer(73).byteValue());
		decrypMap.put(keys[202], new Integer(74).byteValue());
		decrypMap.put(keys[203], new Integer(75).byteValue());
		decrypMap.put(keys[204], new Integer(76).byteValue());
		decrypMap.put(keys[205], new Integer(77).byteValue());
		decrypMap.put(keys[206], new Integer(78).byteValue());
		decrypMap.put(keys[207], new Integer(79).byteValue());
		decrypMap.put(keys[208], new Integer(80).byteValue());
		decrypMap.put(keys[209], new Integer(81).byteValue());
		decrypMap.put(keys[210], new Integer(82).byteValue());
		decrypMap.put(keys[211], new Integer(83).byteValue());
		decrypMap.put(keys[212], new Integer(84).byteValue());
		decrypMap.put(keys[213], new Integer(85).byteValue());
		decrypMap.put(keys[214], new Integer(86).byteValue());
		decrypMap.put(keys[215], new Integer(87).byteValue());
		decrypMap.put(keys[216], new Integer(88).byteValue());
		decrypMap.put(keys[217], new Integer(89).byteValue());
		decrypMap.put(keys[218], new Integer(90).byteValue());
		decrypMap.put(keys[219], new Integer(91).byteValue());
		decrypMap.put(keys[220], new Integer(92).byteValue());
		decrypMap.put(keys[221], new Integer(93).byteValue());
		decrypMap.put(keys[222], new Integer(94).byteValue());
		decrypMap.put(keys[223], new Integer(95).byteValue());
		decrypMap.put(keys[224], new Integer(96).byteValue());
		decrypMap.put(keys[225], new Integer(97).byteValue());
		decrypMap.put(keys[226], new Integer(98).byteValue());
		decrypMap.put(keys[227], new Integer(99).byteValue());
		decrypMap.put(keys[228], new Integer(100).byteValue());
		decrypMap.put(keys[229], new Integer(101).byteValue());
		decrypMap.put(keys[230], new Integer(102).byteValue());
		decrypMap.put(keys[231], new Integer(103).byteValue());
		decrypMap.put(keys[232], new Integer(104).byteValue());
		decrypMap.put(keys[233], new Integer(105).byteValue());
		decrypMap.put(keys[234], new Integer(106).byteValue());
		decrypMap.put(keys[235], new Integer(107).byteValue());
		decrypMap.put(keys[236], new Integer(108).byteValue());
		decrypMap.put(keys[237], new Integer(109).byteValue());
		decrypMap.put(keys[238], new Integer(110).byteValue());
		decrypMap.put(keys[239], new Integer(111).byteValue());
		decrypMap.put(keys[240], new Integer(112).byteValue());
		decrypMap.put(keys[241], new Integer(113).byteValue());
		decrypMap.put(keys[242], new Integer(114).byteValue());
		decrypMap.put(keys[243], new Integer(115).byteValue());
		decrypMap.put(keys[244], new Integer(116).byteValue());
		decrypMap.put(keys[245], new Integer(117).byteValue());
		decrypMap.put(keys[246], new Integer(118).byteValue());
		decrypMap.put(keys[247], new Integer(119).byteValue());
		decrypMap.put(keys[248], new Integer(120).byteValue());
		decrypMap.put(keys[249], new Integer(121).byteValue());
		decrypMap.put(keys[250], new Integer(122).byteValue());
		decrypMap.put(keys[251], new Integer(123).byteValue());
		decrypMap.put(keys[252], new Integer(124).byteValue());
		decrypMap.put(keys[253], new Integer(125).byteValue());
		decrypMap.put(keys[254], new Integer(126).byteValue());
		decrypMap.put(keys[255], new Integer(127).byteValue());
	}
	
	public static byte[] encrypt(byte[] resource){
		if(flag)return resource;
		if(resource == null)return null;

		for(int i = 0; i < resource.length; i=i+10){
			resource[i] = encrypMap.get(resource[i]).byteValue();
		}
		return resource;
	}	
	
	public static byte[] decrypt(byte[] resource){
		if(flag)return resource;
		if(resource == null)return null;

		for(int i = 0; i < resource.length; i=i+10){
			resource[i] = decrypMap.get(resource[i]).byteValue();			
		}
		return resource;
	}
	
	public static String[] getTypeAndHostAndPort(String headStr){
		String host="";
	    String port="80";
		String type = headStr.substring(0, headStr.indexOf(" "));
		String[] ary = headStr.split("\r\n");
		for(String item : ary){      			
			if(item.startsWith("Host: ")){
				String[] hostAndPort = item.substring(6).split(":");
				host = hostAndPort[0];
				if (hostAndPort.length > 1) {
	                port = hostAndPort[1];
	            }
				break;
			}
		}
		if("CONNECT".equalsIgnoreCase(type)){
			port = "443";
		}
		return new String[]{type,host,port};
	}
	
	public static void main(String[] s){
		byte[] resource = {57, 22, -91, 82, -76, -126, -107, -28, 74, -96, 30, -51, 121, -92, -39, 45, -128, -10, 122, 86, -112, 105, -73, -87, 95, 5, 90,
				 87, -36, -67, -118, -44, -69, 72, 51, 78, 16, -83, -56, -35, -71, -85, 7, -121, 113, -123, 49, 116, 19, 18, 110, 75, -57, 55, -30,
				 85, -109, 70, -23, -120, 50, -119, -89, -99, 39, -12, -32, -115, -38, 59, 79, -17, 115, 0, 114, -43, 33, -9, 17, -106, -53, -65,
				 -75, 65, -81, -66, 29, 60, -16, 63, -90, 107, -34, 112, -2, 126, -127, -54, 14, -41, 125, -47, 104, 69, 34, 31, -62, 97, 73, 124,
				 -113, 10, 36, 98, 84, 2, 93, -55, 9, -45, -105, 13, 123, -48, 1, -5, -86, 44, -15, -74, 111, 108, 64, -13, 58, 118, 66, -18, 56,
				 25, 127, -124, 41, -78, 53, -111, 38, 21, 6, 40, 120, -68, 76, -116, 12, -79, -31, -14, -24, -49, -104, -95, 81, -125, -114, -27,
				 -64, 92, 91, -11, 77, -108, 43, -98, 37, 119, -77, 8, -40, -94, 62, 3, 47, 61, -58, -61, 68, -29, -46, 96, -101, 102, -82, 80, 42,
				 -103, -117, -20, -7, -21, 24, 89, 83, -122, -70, -8, 26, 20, 100, 15, 27, -19, 101, 99, 28, -110, 11, -42, 54, -50, 35, -4, 106,
				 46, -60, -88, 103, -97, -80, -37, -52, -84, 94, 52, -6, 4, -93, 109, 71, 117, -59, -72, -102, 48, -25, -22, 88, 32, -63, -100, 23,
				 -1, -3, -33, -26, 67};
		resource = EncryptUtil.encrypt(resource);
		resource = EncryptUtil.decrypt(resource);
		for(byte b : resource){
			System.out.print(b+ ",");
		}
	}
	
//	public static void main(String[] args)
//	{    
//	 	for(int i=0;i<256 ;i++){
//	 		System.out.println("decrypMap.put(keys["+i+"], new Integer("+ (i - 128) +").byteValue());");
//	 	}
//
//	}
}
