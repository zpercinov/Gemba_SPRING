-- =====================================================
-- SIFARNICI ZA GEMBA APLIKACIJU (SQLite verzija)
-- =====================================================

-- 1. KLasteri
INSERT OR IGNORE INTO Cluster (IDCluster, Naziv) VALUES (1, 'SEE');
INSERT OR IGNORE INTO Cluster (IDCluster, Naziv) VALUES (2, 'PC Vrsac');

-- 2. Funkcije
INSERT OR IGNORE INTO Function (IDFun, Ime) VALUES (1, 'Production');
INSERT OR IGNORE INTO Function (IDFun, Ime) VALUES (2, 'Warehouse');
INSERT OR IGNORE INTO Function (IDFun, Ime) VALUES (3, 'QC');
INSERT OR IGNORE INTO Function (IDFun, Ime) VALUES (4, 'Engineering');
INSERT OR IGNORE INTO Function (IDFun, Ime) VALUES (5, 'OpEx');
INSERT OR IGNORE INTO Function (IDFun, Ime) VALUES (6, 'HSE');
INSERT OR IGNORE INTO Function (IDFun, Ime) VALUES (7, 'Culture&People');

-- 3. Sajtovi
INSERT OR IGNORE INTO Site (IDSite, Ime, IDCluster) VALUES (1, 'SEE', 1);
INSERT OR IGNORE INTO Site (IDSite, Ime, IDCluster) VALUES (2, 'Vrsac&Dubovac', 1);
INSERT OR IGNORE INTO Site (IDSite, Ime, IDCluster) VALUES (3, 'Sabac', 1);
INSERT OR IGNORE INTO Site (IDSite, Ime, IDCluster) VALUES (4, 'Banja Luka', 1);
INSERT OR IGNORE INTO Site (IDSite, Ime, IDCluster) VALUES (5, 'Podgorica', 1);
INSERT OR IGNORE INTO Site (IDSite, Ime, IDCluster) VALUES (6, 'PC Vrsac', 2);

-- 4. Role
INSERT OR IGNORE INTO Rola (IDRole, Ime) VALUES (1, 'Administrator');
INSERT OR IGNORE INTO Rola (IDRole, Ime) VALUES (2, 'Edit');

-- 5. Nosioci
INSERT OR IGNORE INTO Nosilac (IDNos, Naziv) VALUES (1, 'Operacije');
INSERT OR IGNORE INTO Nosilac (IDNos, Naziv) VALUES (2, 'Q shop floor');
INSERT OR IGNORE INTO Nosilac (IDNos, Naziv) VALUES (3, 'QA');
INSERT OR IGNORE INTO Nosilac (IDNos, Naziv) VALUES (4, 'SLT');
INSERT OR IGNORE INTO Nosilac (IDNos, Naziv) VALUES (5, 'CLT');
INSERT OR IGNORE INTO Nosilac (IDNos, Naziv) VALUES (6, 'Proizvodnja');
INSERT OR IGNORE INTO Nosilac (IDNos, Naziv) VALUES (7, 'Skladiste');
INSERT OR IGNORE INTO Nosilac (IDNos, Naziv) VALUES (8, 'QC MBL');
INSERT OR IGNORE INTO Nosilac (IDNos, Naziv) VALUES (9, 'QC FHL');
INSERT OR IGNORE INTO Nosilac (IDNos, Naziv) VALUES (10, 'OpEx');
INSERT OR IGNORE INTO Nosilac (IDNos, Naziv) VALUES (11, 'HSE');
INSERT OR IGNORE INTO Nosilac (IDNos, Naziv) VALUES (12, 'Culture&People');

-- 6. Odeljenja
INSERT OR IGNORE INTO Odeljenje (IDOdeljenje, Ime, IDFun) VALUES (1, 'VS SDF', 1);
INSERT OR IGNORE INTO Odeljenje (IDOdeljenje, Ime, IDFun) VALUES (2, 'VS PIP', 1);
INSERT OR IGNORE INTO Odeljenje (IDOdeljenje, Ime, IDFun) VALUES (3, 'VS PSP', 1);
INSERT OR IGNORE INTO Odeljenje (IDOdeljenje, Ime, IDFun) VALUES (4, 'VS Dubovac', 1);
INSERT OR IGNORE INTO Odeljenje (IDOdeljenje, Ime, IDFun) VALUES (5, 'SA SDF', 1);
INSERT OR IGNORE INTO Odeljenje (IDOdeljenje, Ime, IDFun) VALUES (6, 'SA liquids', 1);
INSERT OR IGNORE INTO Odeljenje (IDOdeljenje, Ime, IDFun) VALUES (7, 'SA semisolids', 1);
INSERT OR IGNORE INTO Odeljenje (IDOdeljenje, Ime, IDFun) VALUES (8, 'SA disinfection', 1);
INSERT OR IGNORE INTO Odeljenje (IDOdeljenje, Ime, IDFun) VALUES (9, 'SA probiotics', 1);
INSERT OR IGNORE INTO Odeljenje (IDOdeljenje, Ime, IDFun) VALUES (10, 'BL SDF', 1);
INSERT OR IGNORE INTO Odeljenje (IDOdeljenje, Ime, IDFun) VALUES (11, 'BL packaging powders', 1);
INSERT OR IGNORE INTO Odeljenje (IDOdeljenje, Ime, IDFun) VALUES (12, 'PG SDF', 1);
INSERT OR IGNORE INTO Odeljenje (IDOdeljenje, Ime, IDFun) VALUES (13, 'PG SNUP', 1);
INSERT OR IGNORE INTO Odeljenje (IDOdeljenje, Ime, IDFun) VALUES (14, 'PG Oftal& infusions', 1);
INSERT OR IGNORE INTO Odeljenje (IDOdeljenje, Ime, IDFun) VALUES (15, 'QC sampling', 3);
INSERT OR IGNORE INTO Odeljenje (IDOdeljenje, Ime, IDFun) VALUES (16, 'QC chem', 3);
INSERT OR IGNORE INTO Odeljenje (IDOdeljenje, Ime, IDFun) VALUES (17, 'QC mbl', 3);
INSERT OR IGNORE INTO Odeljenje (IDOdeljenje, Ime, IDFun) VALUES (18, 'Warehouse-CW', 2);
INSERT OR IGNORE INTO Odeljenje (IDOdeljenje, Ime, IDFun) VALUES (19, 'Warehouse-Receiving WH', 2);
INSERT OR IGNORE INTO Odeljenje (IDOdeljenje, Ime, IDFun) VALUES (20, 'Warehouse-Dubovac WH', 2);
INSERT OR IGNORE INTO Odeljenje (IDOdeljenje, Ime, IDFun) VALUES (21, 'Warehouse-Packaging WH', 2);
INSERT OR IGNORE INTO Odeljenje (IDOdeljenje, Ime, IDFun) VALUES (22, 'Warehouse-FG WH ', 2);
INSERT OR IGNORE INTO Odeljenje (IDOdeljenje, Ime, IDFun) VALUES (23, 'VS PSP INF', 1);
INSERT OR IGNORE INTO Odeljenje (IDOdeljenje, Ime, IDFun) VALUES (24, 'VS PSP SIK', 1);
INSERT OR IGNORE INTO Odeljenje (IDOdeljenje, Ime, IDFun) VALUES (25, 'VS PSP LIO', 1);
INSERT OR IGNORE INTO Odeljenje (IDOdeljenje, Ime, IDFun) VALUES (26, 'VS PSP AMP', 1);
INSERT OR IGNORE INTO Odeljenje (IDOdeljenje, Ime, IDFun) VALUES (27, 'PG QC MBL', 3);
INSERT OR IGNORE INTO Odeljenje (IDOdeljenje, Ime, IDFun) VALUES (28, 'PG QC FHL', 3);
INSERT OR IGNORE INTO Odeljenje (IDOdeljenje, Ime, IDFun) VALUES (29, 'PG Warehouse SDF', 2);
INSERT OR IGNORE INTO Odeljenje (IDOdeljenje, Ime, IDFun) VALUES (30, 'PG Warehouse LDF', 2);
INSERT OR IGNORE INTO Odeljenje (IDOdeljenje, Ime, IDFun) VALUES (31, 'PG Engineering SDF', 4);
INSERT OR IGNORE INTO Odeljenje (IDOdeljenje, Ime, IDFun) VALUES (33, 'PG Engineering LDF', 4);
INSERT OR IGNORE INTO Odeljenje (IDOdeljenje, Ime, IDFun) VALUES (36, 'Engineering', 4);
INSERT OR IGNORE INTO Odeljenje (IDOdeljenje, Ime, IDFun) VALUES (37, 'PC Proizvodnja', 1);
INSERT OR IGNORE INTO Odeljenje (IDOdeljenje, Ime, IDFun) VALUES (38, 'VS SDF tableting', 1);
INSERT OR IGNORE INTO Odeljenje (IDOdeljenje, Ime, IDFun) VALUES (39, 'VS PIP lyo', 1);
INSERT OR IGNORE INTO Odeljenje (IDOdeljenje, Ime, IDFun) VALUES (41, 'VS PIP HPV', 1);
INSERT OR IGNORE INTO Odeljenje (IDOdeljenje, Ime, IDFun) VALUES (42, 'VS PSP ampoules', 1);
INSERT OR IGNORE INTO Odeljenje (IDOdeljenje, Ime, IDFun) VALUES (43, 'VS PSP lyo', 1);
INSERT OR IGNORE INTO Odeljenje (IDOdeljenje, Ime, IDFun) VALUES (45, 'VS PSP plastic', 1);

-- 7. Vrste Gembe
INSERT OR IGNORE INTO VrstaGembe (IDVrstaGem, Naziv) VALUES (1, 'Quality');
INSERT OR IGNORE INTO VrstaGembe (IDVrstaGem, Naziv) VALUES (2, 'People');
INSERT OR IGNORE INTO VrstaGembe (IDVrstaGem, Naziv) VALUES (3, 'Cost/delevery');
INSERT OR IGNORE INTO VrstaGembe (IDVrstaGem, Naziv) VALUES (4, '5S');
INSERT OR IGNORE INTO VrstaGembe (IDVrstaGem, Naziv) VALUES (5, 'Safety');

-- 8. Ishodi
INSERT OR IGNORE INTO Ishod (IDIshod, Naziv) VALUES (1, 'OK');
INSERT OR IGNORE INTO Ishod (IDIshod, Naziv) VALUES (2, 'NIJE OK');
INSERT OR IGNORE INTO Ishod (IDIshod, Naziv) VALUES (3, 'NIJE PROVERENO');

-- 9. Aktivnosti
INSERT OR IGNORE INTO Aktivnost (IDAktivnosti, Naziv, IDVrstaGem) VALUES (1, 'Ulazak i ponasanje u cistim zonama', 1);
INSERT OR IGNORE INTO Aktivnost (IDAktivnosti, Naziv, IDVrstaGem) VALUES (2, 'Cistoca prostora i opreme', 1);
INSERT OR IGNORE INTO Aktivnost (IDAktivnosti, Naziv, IDVrstaGem) VALUES (3, 'Oprema i prostorije su u odrzavanom i ispravnom stanju', 1);
INSERT OR IGNORE INTO Aktivnost (IDAktivnosti, Naziv, IDVrstaGem) VALUES (4, 'Zapisi o seriji popunjavaju tačno i potpuno', 1);
INSERT OR IGNORE INTO Aktivnost (IDAktivnosti, Naziv, IDVrstaGem) VALUES (5, 'Pravilno dokumentovanje ključnih parametara procesa i eventualnih odstupanja', 1);
INSERT OR IGNORE INTO Aktivnost (IDAktivnosti, Naziv, IDVrstaGem) VALUES (6, 'Pregled azurnosti i popunjenosti log book-ova', 1);
INSERT OR IGNORE INTO Aktivnost (IDAktivnosti, Naziv, IDVrstaGem) VALUES (7, 'Prisustvo statusnih etiketa na opremi i prostorijama', 1);
INSERT OR IGNORE INTO Aktivnost (IDAktivnosti, Naziv, IDVrstaGem) VALUES (8, 'Aktivnost_People', 2);
INSERT OR IGNORE INTO Aktivnost (IDAktivnosti, Naziv, IDVrstaGem) VALUES (9, 'Aktivnost_Cost_delevery', 3);
INSERT OR IGNORE INTO Aktivnost (IDAktivnosti, Naziv, IDVrstaGem) VALUES (10, '1S - Sortiranje (Sort)', 4);
INSERT OR IGNORE INTO Aktivnost (IDAktivnosti, Naziv, IDVrstaGem) VALUES (11, 'Aktivnost_Safety1', 5);
INSERT OR IGNORE INTO Aktivnost (IDAktivnosti, Naziv, IDVrstaGem) VALUES (12, 'Aktivnost_Safety2', 5);
INSERT OR IGNORE INTO Aktivnost (IDAktivnosti, Naziv, IDVrstaGem) VALUES (13, '2S -Sredjivanje (Set in Order)', 4);
INSERT OR IGNORE INTO Aktivnost (IDAktivnosti, Naziv, IDVrstaGem) VALUES (14, '3S - Spremini/ocistiti (Shine)', 4);
INSERT OR IGNORE INTO Aktivnost (IDAktivnosti, Naziv, IDVrstaGem) VALUES (15, '4S - Standardizovati (Standardization)', 4);
INSERT OR IGNORE INTO Aktivnost (IDAktivnosti, Naziv, IDVrstaGem) VALUES (16, '5S - Samodisciplina (Sustain)', 4);
INSERT OR IGNORE INTO Aktivnost (IDAktivnosti, Naziv, IDVrstaGem) VALUES (17, '6S - Sigurnost (Safety)', 4);

-- 10. Zamerke (sve)
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (1, 'Sminka', 1);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (2, 'Kapa/maska za bradu', 1);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (3, 'Odelo', 1);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (4, 'Radna obuca', 1);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (5, 'Nosenje zastitne opreme (naocare, maske)', 1);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (6, 'Nosenje nakita/laka i sl', 1);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (7, 'Nosenje mob.telefona', 1);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (8, 'Neadekvatna higijena/urednost', 1);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (9, 'Kafa/pice/hrana', 1);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (10, 'Necistoce u hodnicima/neproizvodnim prostorijama (dlake, niti, mrvice, insekti)', 2);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (11, 'Tragovi sirovina/ proizvoda u hodnicima', 2);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (12, 'Neadekvatno ciscenje proizvodnih prostorija', 2);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (13, 'Neadekvatno stanje sredstava za ciscenje', 2);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (14, 'Neadkevatno postupanje sa otpadom', 2);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (15, 'Neadekvatna cistoca paleta/kontejnera za transport materijala', 2);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (16, 'Prisustvo rdje', 3);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (17, 'Oprema - manji kvarovi', 3);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (18, 'Oprema je van funkcije i/ili ugrozava bezbednost', 3);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (19, 'Protokol - nedostaju podaci o sprovedenim aktivnostima', 4);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (20, 'Protokol - podaci su upisani unapred', 4);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (21, 'Protokol - nedostaje pregled/potvrda aktivnosti', 4);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (22, 'Protokol - drugo', 4);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (23, 'Kljucni parametri nisu ispravno zabelezeni', 5);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (24, 'Nije notirano odstupanje od klj.parametara', 5);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (25, 'Evidencija vanrednih aktivnosti usled odstupanja  (kvarova, zastoja, vanrednih sanitizacija, fumigacija)', 5);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (26, 'Podaci u log booku su necitljivi , popunjavanje u skladu sa dobrom dokumentacionom praksom', 6);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (27, 'Logbook nije azurno popunjen', 6);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (28, 'Logbook popunjen unapred', 6);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (29, 'Logbook ne sadrzi periodicni pregled prema RU', 6);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (30, 'Integritet same sveske narusena, pocepan ili sl', 6);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (31, 'Logbook nije otvoren /zatvoren u skladu sa OP, nije arhiviran u skladu sa OP', 6);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (32, 'Nedostaju statusne etikete (cisto/prljavo..)', 7);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (33, 'Neobelezen proizvod/materijal', 7);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (34, 'Neispravno obelezen proizvod/materijal (na pr nedostaje broj serije)', 7);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (35, 'Nedostaju ili su ostecene etikete o kalibraciji', 7);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (36, 'Nedostaju podaci o roku trajanja (na pr hemikalije, srd za sanitizaciju i sl)', 7);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (37, 'Etikete drugo', 7);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (38, 'Ponasanje u skladu sa procedurama u toku procesa proizvodnje/razmeravanja/ispitivanja', 1);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (39, 'Ponasanje drugo', 1);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (40, 'Neadekvatna cistoca ciste opreme', 2);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (41, 'Cistoca drugo', 2);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (42, 'Osteceni zidovi, plafoni, vrata, kvar izvora svetlosti', 3);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (43, 'Stanje laboratorijske opreme /posudja u IPC laboratorijama', 3);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (44, 'Oprema i prostor drugo', 3);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (45, 'Klj.parametri drugo', 5);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (46, 'Frekvenca evidencije u log book-u nije u skladu sa propisanom', 6);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (47, 'Logbook drugo', 6);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (48, 'Neadekvatno oznacen opasan /neopasan otpad', 7);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (49, 'Nedostaje print vage/etiketa reslo za reslo materijal', 7);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (50, 'Integritet pecata na vratima ukoliko postoji', 7);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (51, 'Neobelezena oprema koja se ne koristi ( kvar, trenutno se ne koristi)', 7);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (52, 'Ostalo_People', 8);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (53, 'Ostalo__Cost_delevery', 9);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (54, 'Nisu svi materijali - uključujući in-process zalihe, pribor, alate, formate/oprema u prostoru potrebni.', 10);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (55, 'Ostalo_Safety', 11);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (56, 'Svi materijali/oprema u prostoru i imaju svoje mesto na kome su i smesteni?', 13);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (57, 'Police i skladišni prostor nisu jasno obeleženi, ne zna se koji deo čemu pripada.', 13);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (58, 'Minimalno potrebne i maksimalno dozvoljene količine materijala nisu određene i ispoštovane.', 13);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (59, 'Dostupnost materijala/opreme nije usklađena sa frekvencijom upotrebe, frekvencija upotrebe ne opravdava njihovo pozicioniranje.', 13);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (60, 'Nisu svi materijali/oprema/prostor adekvatno identifikovani, uključujući i status očišćenosti gde je potrebno.', 13);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (61, 'Putanje predviđene za prolazak ljudi i materijala nisu čiste i prohodne. Na podu su kutije, delovi ili kablovi, i ima nepotrebnih materijala.', 13);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (62, 'Podovi nisu čisti, sjajni, bez otpada, vode, ulja i ostalih nečistoća.', 14);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (63, 'Mašine i oprema se ne čiste u skladu sa procedurama i ne čuvaju na način koji će sprečiti oštećenja.', 14);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (64, 'Provera čistoće opreme nije sastavni deo procesa održavanja opreme.', 14);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (65, 'Nema osobe odgovorne za čišćenje/održavanje opreme.', 14);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (66, 'Sve aktivnosti čišćenja nisu zabeležene, proces čišćenja ne sprečava bilo kakvu dvosmislenost (OPL prisutne tamo gde je opravdano).', 14);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (67, 'Za svaki prostor/lokaciju ne postoji osoba koja je zadužena za sprovođenje i održavanje statusa postignutih sa prva 3S.', 15);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (68, 'Tamo gde je primenjivo, nema OPL.', 15);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (69, 'GMP i ISO relevantna dokumentacija ne se nalazi na mestu primene.', 15);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (70, '6S Gembu se ne održavaju redovnom frekvencijom, ne u skladu sa planom Gembi.', 15);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (71, '6S Scorecard (index zrelosti) za lokaciju/prostor nije uspostavljen.', 16);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (72, 'Aktivnosti se ne redovno beleže i ažuriraju.', 16);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (73, 'Zaposleni ne nose odgovarajuću zaštitnu opremu koja se zahteva za njihovu trenutnu radnju.', 17);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (74, 'Radno okruženje nije odgovarajuće za rad (osvetljenje, kvalitet vazduha, temperatura...).', 17);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (75, 'Alati, pomoćna oprema, delovi, in-procesne zalihe i lična zaštitna oprema nisu bezbedno čuvani (neodgovarajuća visina, lokacija, bezbedan pristup, masa...).', 17);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (76, 'Odgovarajuća oprema i alat nisu obezbeđeni za trenutnu radnu aktivnost.', 17);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (77, 'Putevi za pristup opremi koja se koristi za bezbedan rad/zaštitu nisu prohodni i jasno identifikovani.', 17);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (78, 'Otpad nije pravilno razvrstan i obeležen.', 17);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (79, 'Hemikalije nisu pravilno uskladištene i obeležene.', 17);
INSERT OR IGNORE INTO Zamerka (IDZamerka, Naziv, IDAktivnosti) VALUES (80, 'Rad se ne obavlja na ergonomski način, nema mogućnosti za poboljšanje položaja tela, načina manipulacije.', 17);

-- 11. ADMIN KORISNIK
-- Brišemo ako postoji stari pa ubacujemo novog
DELETE FROM Korisnik WHERE IDKorisnik = 1;
INSERT INTO Korisnik (IDKorisnik, UserName, ImePrezime, IDSite, IDRola, DatumUnosa, IDKorisnikUnos, Lozinka)
VALUES (1, 'admin', 'Vitez Koja', 1, 1, datetime('now'), 1, 'admin123');
