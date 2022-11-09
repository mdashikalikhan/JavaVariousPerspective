package com.leetcode.practice;

import java.math.BigInteger;
import java.util.Arrays;

public class SubStringWithHashValue {

	public static void main(String[] args) {
		/**
		 * "xxterzixjqrghqyeketqeynekvqhc"
		 * 15
		 * 94
		 * 4
		 * 16
		 */
		String s = "xxterzixjqrghqyeketqeynekvqhc";//"leetcode";//"xmmhdakfursinye";

		s = "jjsqisvhotspeikujucpaaawtppgbpbctikdyekxwtaojnmgrqydavlipzkikpsomusskccfggvqqlsatpbcxfyvvkrdfxfwocjpuhbibsaiyyndsvthlbtwtqstnfjodfeuvkytbzmybtluwrqctocnrzemwwohssomjbyfzzcyzjwvyzmquloytzorppbimqyiwpxrjnuoihqsrxcqugnxteqydwwytzehxoluhvdddjjbyyjodejwqotdjcdkcorumjangcbmhbbktthehnbxfokpynficbrygnaljpwakppnponxkwsftlcbzbhiiwlgcpmebbntmzndbkiuudhaokjccuonicgogleiwzbtuyvsanjgrkoqvqoxzyzewzdayvarjhoskdrxyzsyrqyzljvzoamlquykxgncdgsqwousjpxzysdsrmhnrculiizkicwcwbzlzjplggzeelrssvlyrckjymyeoadnwscndctmgifofpqpssgttsdlnhiqwfsqdfdosplbznwfhaoneuzzrhzvprsjvongqtylwqlfmnnivqalexfetesurrpsiixzkxtuhpvhkvkfcnoqzxkuwtubugpvjgjbafkglgljjgtqeywwkgdahonkkhxoxrrpnzxbqzcurhxeolpehinczdhrucodyishybuhimsswuugaxhwyiquasnwnedzvnoklomlsygretfhbeuuqexhnssdodkxwkknvqbfmspfqhpcstwzgebqsevhaezqlgnkatojsjpvgcdzxwpdkcignackxsplvtlacxxqnpczwzgmrwwcslyubvwatrcsvvxdxxdcmqnxytbqrcxwkzhbshnhgckmaqwhvibfvksqnmhirtbeokeluihsiaolsbgejanaogafxvqmfupyqbvwhwuzyfzzkuhofigiglspskcdgcjdkkertgubcyvrqhkixqeanuhiydqtjdfupagnuzcgwiuzjoepempyskssqxuiurjombqzrqwfnkffaslotmvqvevnoiigsgvskrskzntajgsamkjlmnzrfjlrldvnkgkfuorfyvzxqysnydqkznswkdflxhpqhycngckfwzobttcdzerpkajkssymxlboeujscvdugebjqlbtqvbpzupmrzqemskkbirdjfjdyvahyolceaxwbesuhzgzkmcferenjigioxiceltlhnfhggvxrmiehnrpvgkqpvyxritwnuykrkbnnjkrpavyahgstyachgwqnzzrpgteboxrspgsstrqgyiequakednbnwlrioexnajbcksjcgaogzmiqkjflteoqqspxwlimqhsvhelyyntstklldkmjrwmuajctcghfrkmshbottnqweqxpnkjvbbahteoasidtavaztelnnrotoxzeaisgcmcktzeltblqirozyuinwyexbmcoflnycvwtchhzahxdrzrvahttplghnwscltqsobxuokslmflnigjcwoixgbmvxfmmwyzygtghunrhglbgpfkniiionkcvtaabkqcgzjgdpahqtdrryrxhkqdsqblcwlxqwjwdzdhqbgzkpzqrkbpyzeunlbxyhvnnsktsieuibigdwwpyhzhxiiqsyqhgbgcerjybrgmajlkqpfekvfkyrqkitwlifcyevgobnoixymbormtiovydqirmsrzcrqilenokbslfjnftmteukcmkmdpghtadlnyifhrrftysqismhjnduwkfqaqowilszniftwuipihqnupckjcqxcedtvlgfytbblvlxexfbewmsgasoytmvbjtvnsishmfzbajufzmtlaecyphhkgenjuznwrtwawwlxedsaufizjvinmubwieahrtfdscnztzxvyfoqfdxqsxyouavexmmvusetfsohshusizlyduhayaqkwqrijamkvppqtfmnghlosbbihtntkjykvttgubsffrkzpzjqnxsqchwnblmonjnlqzsjwmalcyjdwhaznchowukfpqqyetoamixxhykglmqedhbvuggnxqyetskocnoykmyieeesqqshlrdjnlemndpdiouvbcspirwjrwqhzybkfgeufafoinqedkxofvnhhxjmirtpqpebazuzqyyrhmcigxmtvmwexfzsbhajifnszfhnklinarycgkgvuftlbfolvjswalctndudzwqhyswrljeaerhstwzbrmsbaefecijjwwnjtyjifdyzkqnntsazebvqnqefmzfwcrhihkirajrcvyqbjzjayejtgrfqycmbdmdscyknrclvhdabpicpjgmutahvnnttmdncfkonfxmjvectbcuduufscwhuljvfnaozrcrcstbjbarbffjezwmteiwtmxxnkmhinoyvoswhbzzpunumxnypqjcbmhrharjuavmalzxodwizysxtihfopxknavtosxieveutwncatzhunqtecqwimmjccscaywtwuzybaonnrnxosqvzjgvbvpskqobrnzmkevscrnicodkkjkhopdbaiylhbprzigcuwhbtsztlvizcopredauwkhbpxkdnakbzngyerqqmiuogsvqrtbuvlvgiovgwgssejqxqlropnimtpplbpgirzpiwhptfspmfdzkgzrqhrhagtmwqkdrojggptiapsfucehthehzkvntlqyccotcokmtswshtrcukgydtsiubvghmysgjqfmmkeajzozmiownfeqkqxvjhzlpglzziqtqbnigsgpebhztzibqwnubpxqzaugmzwxiwziyultqqljcbitcinppxyyrhyadnyjgyojpxcvbzmuwsooaqcijerbfbnusvrgexhefzrzjifsjxluoekzdwipizhxbnpvndxztlxiutruwwopgsvvbflfvisrypkatjaspgrxgxmudmiymtjnifrsgguyxjfpzbvxsbproxmhnzuqwtscsexszfhjpotmwunkoamcyamzrtjbnyamkexnxqhfubxtoghwxnvktamgfsioqbgvdmgbfdnfwgesuiemkgldiclwushprpfvtfgbltgbcbozmwrvcykkchrfzluohgmubiudaflohipbtvmaisnmqnqlnktmmtflaelttkcskplhplgddkolwmiozbpuusvtsankcmndkasrekionwprcrwzfxgcdkoyfvvltfqdxnwvhlrwcjzilqkicmtpedrwsyneusptancuhyevlywwpfnnhcpwijvrhbjymlopexuqzbcipiinjeufarvlieumlcnqlkdtainghuupgxwolllpzequncsygcxzhboqejwcfzplrkolgqbioeehmzjzklicaiclffanqoiaqhzzqjpdhiwsuxgtihamzaqilsqjynrqkwbcejudetxpvgcibfsrmhathgleycspxpebdjfwmninkokahzmjvbxxirsuayuijglernorbcyljbfroknuhwzcconrpgdwmugujdpnbxkmoyjcpovqbbtqjwoqyezqzytepywestmkjfvuxcihpwxdbqksogaqetnfhnadafqvysdmbowselvlogkroymzbmykklyspthybmggklxnykgzijyyvktwkxaxypvnkyfvlifwinsawcwqontbabvkvluwojterghwrugtfbvwawahxtivshblpjntykkrrykknzzccavtppwgmcmqtdbjypsprcmpcsmyvrgrtsgrhndngroncbrledwkkpcarjyjrulqsqllwncdnrwwroohpgghtcubwicekrugfgxhslozbmdgfhjigjtjoulpykhxplafywlhtohnymtdfxeacrkydhpeumsjwaxyojkawuqvetwhkonnazgmsclbcgktykkzjtwzfkvyjaazdevaeiexxydknohembciodckvnmgrqzkonviyswpulfvczxbzthntkjxjcfkejnwualfqckzucolwzkdurlcxqbzcozqaotjyownffpionlexjnmxzqlrzieitdjsfdlvsecdrdcehvauiebppipbuevposbqyofngesjuaqllilgewmbjypallcywvjvaqvprmepcyqiwqnpeebinmxwmtxvopmbeioqqnrtakittuozrarwklygnjqrejlrrtqusgtmipbfrlzhowjsoqtiretqwmwjymhybgctwxwveccuisyglfkazynqwpwukxrznzskfbpaothaivqkrikfiwtffaiwkfzgxugmkvbbsivzsublnwmzfctdxjocygesmsuukhjczdjlodafjtferaaygtblsmkvyjcimclwukujisggopdbjrwasqklzfjyhnsuqwvgdteermvkbfxywgsrudxbnujggyqwyrbjevzjdwavdeshclereovtbxvqpxmnrdaevsssvbajaveqlnjtwlzpfjscnnkqlvsnciwdcemttytfjoacoaspzjtgietqziqafduerkfjggnjghrcdzhrsqjbtcctrszwrjxrbqxhpwqbmevnpxeorbgnjabvmzcouibhmikgbwnzgmoqcifjhsqlnslrkchggvydasgtlfxzmnwppottziitcophcjgquzfpinuwyolwsnvboardsaagckwjgokniyftqwbshgphosuxcekugfluosjnooaiourpjjavrmsnsjwnzhkxymtnrhfkmznaylislqrfehfjnlcrpnayyjbygtgsrrgnrunyiwsxwkmgrukhczrhtfkfucukmdqsekkeojxwrluovzteifqwrzlvvmjmnlxkcpbdxpshpfnyakspawjdbeuzmygwnmuauqfekwoqgouqanotfolmbeoeinebltqfesrixrihpvegyxiibtahvqzdzebewgwzttrdkenfwwqftxmrlbxvebvjihdxxqmpvxtwoiwacsajdjivgpiiijddhafhojlwhuukepfoalrybvtlbyvabigioaaijiyousjgysqgtgfyxsneuihovkreehvtpjhbquilstuzvpqokuructrzudmaiuilmjqhtnpktthenzspuzxnoscwygsjgjbchtuygfjshyayazaketsmaxboroghvttphsrfsimyqxavshqkdrbwbojvxkokdlqeddwigsgjbpucundehhgcrwisqnnxoxtwhebbzkmyqtozknvdmnghvueaqzkheanukgzklooigvaldjutsstbjpxqdnppcbcrwlobytzapivxvwmlzfekjcsljexmrjpowvgrpwrwfkfalpuuabhhyplfgkublwpdjibnxmscxrnbycmlnzfkirojynfvaoearzavihuttnmbfctoypnjvevhozzeszffjlimnklintgzvbnrpxwxtxqgemkvksublbmzwwduevrsiiymikmqqezyffdlgqfeatbtpvjljjykzhkpnswphtrvnxfsmijyfkmkb";
		int power = 57884;//15;// 7;//96;
		int modulo = 78507;//94;//20;//45;
		int k = 4278;//4;//2;//15;
		int hashValue = 62326;//16;//0;//21;

		//System.out.println(powerTest(4,3, 5));

		/*s="leetcode";
		power =7;
		modulo =20;
		k=2;
		hashValue=0;*/
		s = "fbxzaad";
		power = 31;
		modulo = 100;
		k = 3;
		hashValue = 32;

		//System.out.println(subStrHash2(s, power, modulo, k, hashValue));
		int x = 57884;
		int exp = 4277;
		int mod = 78507;

		/**
		 * result = 57884^4277 % 78507
		 */

		long result = 1;
		for ( int i = 1; i <= exp; i++ ) {
			result = (result * x % mod) % mod;
		}
		/*System.out.println(result);
		System.out.println((7*7*7*7*7*7*7*7*7)%5);*/

		/*int t = 36 % 7;
		System.out.println(t);
		
		t = ( (t%7) * (1/6 % 7)) % 7;
		System.out.println(t);*/

		/*System.out.println(6%8);
		System.out.println(6*6%8);
		System.out.println(6*6*6%8);
		System.out.println((13*12*11*10)%7);
		System.out.println((13%7*12%7*11%7*10%7)%7);
		System.out.println((13*12%7*11%7*10%7)%7);
		System.out.println(4*27%7 + 21*9%7 + 22*3%7 );
		System.out.println((4*9%7 + 21*3%7 + 22%7) * (3%7));
		System.out.println((4*9%7 + 21*3%7 + 22%7) );
		System.out.println(((4*9%7 + 21*3%7 + 22%7) * (3%7))/(3%7));*/
		String s1 = "-50468001";
		/*char res[] = findSmallestPermutation(s1);
		System.out.println(res);*/
		System.out.println(divide(-2147483648, 2));
		System.out.println(1<<31);
		System.out.println(1>>1);
		System.out.println(1<<1);
	}

	public static int divide(int dividend, int divisor) {

		if (dividend == 0) {
			return 0;
		}
		if (divisor == dividend) {
			return 1;
		}
		if (divisor == 1) {
			return dividend;
		}
	
		if (divisor == -1) {
			if (dividend == Integer.MIN_VALUE) {
				return Integer.MAX_VALUE;
			} else {
				return -dividend;
			}
		}

		int cnt = 0;
		
		int dividend1 = dividend;
		int divisor1 = divisor;
		int dividendMaxNegativeValue = 0;
		int divisorMaxNegativeValue = 0;

		if(dividend1==Integer.MIN_VALUE) {
			dividend1 = dividend1 + 1;
			dividendMaxNegativeValue = 1;
		}
		
		if(divisor1==Integer.MIN_VALUE) {
			divisor1 = divisor1 + 1;
			divisorMaxNegativeValue = 1;
		}
		
		dividend1 = Math.abs(dividend1);
		divisor1=Math.abs(divisor1);
		
		if(divisorMaxNegativeValue==1) {
			return 0;
		}
		while(dividend1>= divisor1) {
			cnt++;
			dividend1 = (dividend1-divisor1);
		}
		dividend1 +=dividendMaxNegativeValue;
		while(dividend1>= divisor1) {
			cnt++;
			dividend1 = (dividend1-divisor1);
		}
		cnt = divisor<0&&dividend<0?cnt:divisor<0||dividend<0?-cnt:cnt;
		
		return cnt;
	}

	static char[] findSmallestPermutation(String s1) {
		// sort the string
		char s[] = s1.toCharArray();
		Arrays.sort(s);

		// check for leading zero in string
		// if there are any leading zeroes,
		// swap the first zero with first non-zero
		// number
		int i = 0;
		while (s[i] == '0')
			i++;

		char temp = s[0];
		s[0] = s[i];
		s[i] = temp;
		return s;
	}

	public static long powerTest(int k, int power, int modulo) {
		long power_1 = 1;
		while (k - 1 > 0) {
			System.out.println(power_1 + " * " + power + " mod " + modulo);
			power_1 = (power_1 * power) % modulo;
			System.out.println(power_1);
			k--;
		}
		return power_1;
	}

	public static String subStrHash2(String s, int power, int modulo, int k, int hashValue) {
		String substr = "";
		long modularArray[] = new long[k];
		modularArray[0] = 1;
		long maxModPower = 1;

		for ( int i = 1; i <= k - 1; i++ ) {
			maxModPower = (maxModPower * power % modulo) % modulo;
			modularArray[i] = maxModPower;
		}

		System.out.println(Arrays.toString(modularArray));
		System.out.println(power + " " + modulo);
		int cnt = k - 1;
		long currentHash = 0;
		for ( int i = s.length() - 1; i >= 0; i-- ) {
			int charVal = (s.charAt(i) - 96);
			if (cnt == 0) {

				currentHash += (charVal * modularArray[cnt]) % modulo;

				if (Math.abs(currentHash) % modulo == hashValue) {
					substr = s.substring(i, i + k);

					//return s.substring(i, i+k);
				}
				/*if(substr.length()>0) {
					System.out.println(currentHash);
				}*/
				int minusCharVal = (s.charAt(i + k - 1) - 96);
				System.out.println(currentHash + " " + s.charAt(i + k - 1) + "  " + ((minusCharVal * modularArray[k - 1]) % modulo));
				currentHash = currentHash - ((minusCharVal * modularArray[k - 1]) % modulo);
				currentHash = (currentHash * (power % modulo)) % modulo;

			} else {
				currentHash += (charVal * modularArray[cnt]) % modulo;
				cnt--;
			}
		}

		return substr;
	}

	public static String subStrHash(String s, int power, int modulo, int k, int hashValue) {
		String substr = "";
		BigInteger currentHash = BigInteger.ZERO;
		int pos = 0;
		int n = s.length();
		int i = 0;
		while (i < n) {

			pos = i % k;

			if (i >= k) {

				long t = (long) (s.charAt(i - k) - 96);
				BigInteger tBig = BigInteger.valueOf(t);
				currentHash = currentHash.subtract(tBig);
				currentHash = currentHash.divide(BigInteger.valueOf(power));
			}
			long t = (long) (s.charAt(i) - 96);
			BigInteger tBig = BigInteger.valueOf(t);
			int exponent = i > k - 1 ? k - 1 : pos;
			BigInteger bigPow = BigInteger.valueOf((long) power).pow(exponent);
			currentHash = currentHash.add(tBig.multiply(bigPow));

			if (i >= k - 1) {
				BigInteger cmod = currentHash.mod(BigInteger.valueOf((long) modulo));
				int currentHashValue = cmod.intValue();

				if (currentHashValue == hashValue) {
					substr = s.substring(i - k + 1, i + 1);
					return substr;
				}

			}

			i++;
		}

		return substr;

	}

}
