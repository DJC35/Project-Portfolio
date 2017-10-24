#include <iostream>
#include <string>
#include <fstream>
#include <cstdlib>

#include "LinkedList.h"
#include "Pair.h"

using namespace std;

// prototypes
unsigned int hashIt(const string& key);
void dump(LinkedList<pair<string,string>>** hashTable, const int hashTableSize);

int main(int argc, char** argv) {
	
	pair<string,string> input;
	int hashTableIndex;

	// create and initialize the hash table
	const int hashTableSize = 25;
	LinkedList<pair<string,string>>* hashTable[hashTableSize];

	// Populate array with LinkedLists
	for (int i = 0; i < hashTableSize; ++i)
		hashTable[i] = new LinkedList<pair<string,string>>;

	// sanity test
	cout << "After Creation and Initialization" << endl;
	dump(hashTable, hashTableSize);//Print HashTable
	cout << endl << endl;

	// Test is there are two arguments (Program name,File name)
	if (argc != 2) {
		cerr << "Usage: " << argv[0] << " data-file" << endl;
		system("pause");
		return EXIT_FAILURE;
	}

	// open the file
	ifstream inputFileStream(argv[1]);

	// if file is unable to open
	if (!inputFileStream) {
		cerr << "Could not open the text file!" << endl;
		system("pause");
		return EXIT_FAILURE;
	}

	// read in the data and add it to the hash table
	while (inputFileStream >> input.first) {
		getline(inputFileStream,input.second);
		hashTableIndex = hashIt(input.first) % hashTableSize;
		hashTable[hashTableIndex]->addToTail(input);
	}

	// close the file
	inputFileStream.close();

	// sanity test
	cout << "After populating the list with 100 pairs of words and their meanings" << endl;
	dump(hashTable, hashTableSize);
	cout << endl << endl;
	system("pause");	
}

/* calculates a hash from a string
 * char1 * 6151 + char2 * 6151 ... +charN * 6151
 */
unsigned int hashIt(const string& key) {

	unsigned int index = 0;

	for (unsigned int i = 0; i < key.size(); ++i)
		index += key[i] * 6151;

	return index;
}

// sanity test, displays the table as it phyically exits
void dump(LinkedList<pair<string,string>>** hashTable, const int hashTableSize) {

	for (int i = 0; i < hashTableSize; ++i)
		if ( hashTable[i]->isEmpty() )
			cout << "hashTable[" << i << "] -> *** IS EMPTY ***" << endl;
		else {
			cout << "hashTable[" << i << "] -> ";
			hashTable[i]->dump();
			cout << endl;
		}
}
/*After Creation and Initialization
hashTable[0] -> *** IS EMPTY ***
hashTable[1] -> *** IS EMPTY ***
hashTable[2] -> *** IS EMPTY ***
hashTable[3] -> *** IS EMPTY ***
hashTable[4] -> *** IS EMPTY ***
hashTable[5] -> *** IS EMPTY ***
hashTable[6] -> *** IS EMPTY ***
hashTable[7] -> *** IS EMPTY ***
hashTable[8] -> *** IS EMPTY ***
hashTable[9] -> *** IS EMPTY ***
hashTable[10] -> *** IS EMPTY ***
hashTable[11] -> *** IS EMPTY ***
hashTable[12] -> *** IS EMPTY ***
hashTable[13] -> *** IS EMPTY ***
hashTable[14] -> *** IS EMPTY ***
hashTable[15] -> *** IS EMPTY ***
hashTable[16] -> *** IS EMPTY ***
hashTable[17] -> *** IS EMPTY ***
hashTable[18] -> *** IS EMPTY ***
hashTable[19] -> *** IS EMPTY ***
hashTable[20] -> *** IS EMPTY ***
hashTable[21] -> *** IS EMPTY ***
hashTable[22] -> *** IS EMPTY ***
hashTable[23] -> *** IS EMPTY ***
hashTable[24] -> *** IS EMPTY ***

After populating the list with 100 pairs of words and their meanings
hashTable[0] -> or --  conjunction used to represent an alternative,
hashTable[1] -> had --  past tense possessive verb, each --  every one of two or
 more considered individually or one by one, so --  in the way or manner indicat
ed, described, or implied, most --  in the greatest quantity, amount, measure, d
egree, or number,
hashTable[2] -> to --  used to express motion or direction toward something, for
 --  intended to belong to, or be used in connection with, than --  except; othe
r than; used to show an alternative, first --  being before all others with resp
ect to time, order, rank, importance, etc., may --  used to express possibilty,
opportunity, or permission,
hashTable[3] -> sound --  the sensation produced by stimulation of the organs of
 hearing by vibrations in the air,
hashTable[4] -> up --  to, toward, or in a more an elevated position,
hashTable[5] -> he --  pronoun indicating a masculine person, place, or thing, t
hem --  objective case of they used as a direct or indirect object, write --  to
 express or communicate in writing, would --  past tense of will; to do somethin
g, did --  past tense of do, my --  possessive case of I ,
hashTable[6] -> was --  used to indicate a past state of being, hot --  having o
r giving off heat, but --  on the contrary; yet, can --  to be able to; have the
 ability, power, or skill to, which --  whichever; any one that, time --  finite
 duration; a limited period or interval, then --  at that time; immediately or s
oon afterward,
hashTable[7] -> and --  conjunction used to group multiple things together, an -
-  the from of a before an initial vowel sound, if --  in caste that; granting o
f supposing that; even though, long --  having considerable linear extent in spa
ce, or time,
hashTable[8] -> that --  used to indicate a specific thing, use --  to employ fo
r some purpose; make use of,
hashTable[9] -> when --  at what time or period, how --  in what way or manner;
by what means?, who --  what person or persons?,
hashTable[10] -> were --  indicates a second person past tense sate of being, mo
re --  in greater quantity, amount, measure, degree, or number, could --  past t
enst form of can, been --  past participle of be,
hashTable[11] -> from --  indicates a specific starting point, what --  pronoun
used interrogatively as a request for specific information, some --  being an un
determined or unspecified amount, there --  in that place; at that point in an a
ction, speech, etc., do --  to perform, execute, or complete,
hashTable[12] -> are --  indicates a present, and plural state of being, as --
to the same degree, amount, or extent; similarly; equally;, way --  manner, mode
, or fashion, many --  constitution of forming a large number, these --  indicat
es a person place or thing as a way of emphasis, look --  to turn one's eyes tow
ard something, call --  to cry out in a loud voice; shout; to ask or invite to c
ome,
hashTable[13] -> of --  used to indicate a source, distance, cause, material, id
entity, or possession, at --  used to indicate a point or place in space; in, on
, or near;, all --  the whole of, your --  pronoun indicating one's possession o
f something, thing --  a meterial object without life of consciousness,
hashTable[14] -> about --  in regard to; connected or associated with, make --
to bring into existence by shaping or changing material, combining parts, etc.,
go --  to move or proceed, especially to or form something,
hashTable[15] -> in --  used to indicate inclusion, this --  indicates a person,
 thing, idea, state, etc., their --  form of possessive case of they, will --  a
m about or going to; am disposed or willing to, down --  from higher to lower; i
n descending direction or order, now --  at the present time or moment; immediat
ely,
hashTable[16] -> has --  third person singular present indicative of have,
hashTable[17] -> they --  pronoun refering to multiple people as a group, said -
-  past tense of speaking, see --  to view or perceive with the eyes, find --  t
o locate, attain, or obtain by search or effort,
hashTable[18] -> him --  the objective case of he used as direct or indirect obj
ect, day --  interval of light between two successive nights; the time between s
unrise and sunset,
hashTable[19] -> with --  accompanied by, or accompanying another thing, by --
near to or next to, word --  a unit of language composed of one or more spoken s
ounds, out --  away from, or not in, the normal or usual place, position, state,
 etc, her --  pronoun indicating ownership by a femminine subject, over --  abov
e in place or position,
hashTable[20] -> is --  used to indicate a present state of being, have --  to p
ossess, own, hold, or contain, we --  plural pronoun indicating the speaker is i
n a group, she --  pronoun used to indicate femminine subjects, come --  to appr
oach or move toward a particular person or place, people --  persons indefinitel
y or collectively; persons in general,
hashTable[21] -> the --  article used to mark a specific person, place, or thing
, it --  pronoun used to represent inanimate or genderless things, on --  to bes
upported by or suspended from another object, other --  additional or further, l
ike --  of the same form, appearance, kind, character, amount, etc., two --  a c
ardinal number, one plus one, no --  a negative used to express dissent, denial,
 or refusal; not at all, side --  either of the two lateral parts or areas of a
thing,
hashTable[22] -> a --  the first letter in the Alphabet, and used as an article
to specify general nouns, one --  indicates a single person, place, or thing, kn
ow --  to perceive or understand as fact or truth; to apprehend clearly and with
 certainty, water --  transparent odorless, tasteless liquid made up of hydrogen
 and oxygen,
hashTable[23] -> I --  pronoun used to refer to oneself,
hashTable[24] -> you --  pronoun indicating someone in second person, his --  pr
onoun indicating possession by a masculine thing, be --  verb indicating existen
ce, or living, number --  a numeral or group of numerals,

Press any key to continue . . .*/