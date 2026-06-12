package wartracker.data;

import wartracker.model.War;
import wartracker.model.War.Status;
import wartracker.model.War.Category;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WarRepository {

    private static final List<War> wars = new ArrayList<>();

    static {
        // ============================================================
        // ACTIVE CONFLICTS
        // ============================================================
        wars.add(new War("ACT001", "Russo-Ukrainian War", "2022", null,
                Status.ACTIVE, Category.POLITICAL, "Eastern Europe",
                Arrays.asList("Russia", "Ukraine", "NATO (support)"),
                "Russia launched a full-scale invasion of Ukraine on February 24, 2022, following years of " +
                "tension and the 2014 annexation of Crimea. The war has caused massive displacement, " +
                "devastated Ukrainian cities, and triggered the largest European refugee crisis since WWII. " +
                "NATO countries have provided substantial military aid to Ukraine.",
                "700,000+ (est. military & civilian combined)",
                "Russian expansionism, NATO enlargement disputes, Ukrainian sovereignty and European integration",
                null));

        wars.add(new War("ACT002", "Gaza–Israel War", "2023", null,
                Status.ACTIVE, Category.RELIGIOUS,
                "Middle East",
                Arrays.asList("Israel", "Hamas", "Palestinian Islamic Jihad", "Hezbollah (Lebanon front)"),
                "Following Hamas's October 7, 2023 surprise attack on Israel that killed ~1,200 Israelis " +
                "and took ~240 hostages, Israel launched a massive military campaign in Gaza. The conflict " +
                "has caused a severe humanitarian crisis with over 2 million people facing dire conditions.",
                "50,000+ (est.)",
                "Decades of Israeli-Palestinian conflict, Hamas governance of Gaza, territorial and religious disputes",
                null));

        wars.add(new War("ACT003", "Sudan Civil War", "2023", null,
                Status.ACTIVE, Category.POLITICAL, "Northeast Africa",
                Arrays.asList("Sudanese Armed Forces (SAF)", "Rapid Support Forces (RSF)"),
                "A power struggle between Sudan's military (SAF) and the paramilitary RSF erupted into " +
                "full-scale war in April 2023. The conflict has created one of the world's worst " +
                "humanitarian crises, with millions displaced and widespread atrocities reported.",
                "150,000+ (est.)",
                "Power struggle between military factions following 2021 coup, control of state resources",
                null));

        wars.add(new War("ACT004", "Myanmar Civil War (Escalated)", "2021", null,
                Status.ACTIVE, Category.POLITICAL, "Southeast Asia",
                Arrays.asList("Military Junta (Tatmadaw)", "People's Defence Force", "Ethnic Armed Organizations"),
                "After the 2021 military coup ousting Aung San Suu Kyi's government, Myanmar descended " +
                "into a nationwide armed resistance. Ethnic armed organizations and a newly formed " +
                "People's Defence Force have seized significant territory from the military.",
                "50,000+ (est.)",
                "Military coup against elected government, decades of ethnic armed conflict",
                null));

        wars.add(new War("ACT005", "Sahel Insurgency", "2012", null,
                Status.ACTIVE, Category.RELIGIOUS, "West Africa (Sahel)",
                Arrays.asList("Mali, Burkina Faso, Niger (juntas)", "JNIM", "ISGS", "Wagner Group (Russia)"),
                "An Islamist insurgency originating in Mali has spread across the Sahel, engulfing " +
                "Burkina Faso and Niger. Multiple coups have occurred. French forces withdrew; Russia's " +
                "Wagner Group now supports the military juntas.",
                "30,000+ since 2012",
                "Islamist extremism, weak governance, Tuareg separatism, poverty, climate stress",
                null));

        wars.add(new War("ACT006", "Tigray War / Ethiopia", "2020", null,
                Status.ACTIVE, Category.ETHNIC, "East Africa",
                Arrays.asList("Ethiopian Federal Government", "Eritrea", "Tigray People's Liberation Front"),
                "A devastating war in northern Ethiopia between federal forces and the TPLF caused one " +
                "of the worst humanitarian crises globally. A peace agreement was signed in Nov 2022, " +
                "though implementation remains contested and violence continues in other Ethiopian regions.",
                "300,000–500,000 (est.)",
                "Political marginalization of Tigray region, federal-regional power conflicts",
                null));

        wars.add(new War("ACT007", "Yemen Civil War", "2014", null,
                Status.ACTIVE, Category.RELIGIOUS, "Arabian Peninsula",
                Arrays.asList("Houthi Movement (Iran-backed)", "Saudi-led Coalition", "Yemen Government"),
                "A multi-sided conflict pitting the Iran-aligned Houthi movement against a Saudi-led " +
                "coalition backing the Yemeni government. Described as the world's worst humanitarian " +
                "crisis, with widespread famine and cholera outbreaks. Houthis have also attacked Red Sea shipping.",
                "377,000+ (including indirect deaths)",
                "Houthi rebellion, sectarian tensions (Shia vs. Sunni), Saudi-Iran proxy conflict",
                null));

        wars.add(new War("ACT008", "Syrian Civil War", "2011", null,
                Status.ACTIVE, Category.POLITICAL, "Middle East",
                Arrays.asList("Assad Government (Russia/Iran-backed)", "SDF (US-backed)", "HTS", "Turkey-backed factions"),
                "Began as Arab Spring protests that became a multi-faction civil war. Assad used chemical " +
                "weapons; ISIS emerged and was largely defeated. Despite Assad's recapture of most territory, " +
                "armed factions remain active and the humanitarian situation is catastrophic.",
                "500,000+ (est.)",
                "Authoritarian repression, sectarian divisions, foreign power interventions",
                null));

        wars.add(new War("ACT009", "Haitian Gang War", "2021", null,
                Status.ACTIVE, Category.POLITICAL, "Caribbean",
                Arrays.asList("Haitian State", "G9 Coalition", "Viv Ansanm gang coalition"),
                "Haiti's collapse of state authority has led to gangs controlling over 80% of the capital " +
                "Port-au-Prince. A Kenyan-led multinational security support mission was deployed in 2024 " +
                "to help restore order amid rampant violence and kidnappings.",
                "5,000+ per year (recent)",
                "Political vacuum post-assassination of President Moïse, extreme poverty, state failure",
                null));

        wars.add(new War("ACT010", "DRC / M23 Conflict", "2022", null,
                Status.ACTIVE, Category.ETHNIC, "Central Africa",
                Arrays.asList("DRC Government", "M23 rebels (Rwanda-backed)", "MONUSCO (UN)"),
                "M23 rebels backed by Rwanda have seized large swaths of eastern DRC including Goma. " +
                "The conflict has roots in the 1994 Rwandan genocide and ongoing competition for " +
                "DRC's vast mineral wealth. Millions have been internally displaced.",
                "10,000+ (recent phase)",
                "Ethnic tensions (Tutsi/Hutu legacy), mineral wealth competition, Rwandan interference",
                null));

        // ============================================================
        // IMMINENT THREATS
        // ============================================================
        wars.add(new War("IMM001", "Taiwan Strait Crisis", "2024", null,
                Status.IMMINENT, Category.POLITICAL, "East Asia",
                Arrays.asList("People's Republic of China", "Republic of China (Taiwan)", "United States (potential)"),
                "China has dramatically escalated military exercises around Taiwan, including unprecedented " +
                "encirclements. China's Xi Jinping has explicitly stated reunification is non-negotiable. " +
                "The US has strengthened arms sales to Taiwan. Military analysts consider an invasion " +
                "scenario increasingly plausible before 2030.",
                "Potentially millions (nuclear-armed parties)",
                "PRC's claim to Taiwan, US-China geopolitical rivalry, Taiwan's de facto independence since 1949",
                null));

        wars.add(new War("IMM002", "Iran–Israel Direct War", "2024", null,
                Status.IMMINENT, Category.RELIGIOUS, "Middle East",
                Arrays.asList("Iran", "Israel", "US (potential)", "Hezbollah", "Houthis"),
                "Iran and Israel have traded direct missile and drone strikes in 2024 — a historic " +
                "escalation after decades of shadow war. Iran's advancing nuclear program and " +
                "Israel's stated red lines create a volatile environment where miscalculation " +
                "could trigger a full regional war.",
                "Potentially hundreds of thousands",
                "Iran's nuclear program, religious-ideological hostility, proxy wars across the region",
                null));

        wars.add(new War("IMM003", "North Korea War Scenario", "2024", null,
                Status.IMMINENT, Category.POLITICAL, "East Asia",
                Arrays.asList("North Korea", "South Korea", "United States", "Japan"),
                "North Korea has tested ICBMs capable of reaching the US mainland, deployed troops to " +
                "support Russia in Ukraine, and declared South Korea its 'principal enemy.' Kim Jong-un " +
                "has abandoned the goal of reunification. Any miscalculation on the Korean peninsula " +
                "would immediately involve US forces.",
                "Potentially millions (nuclear scenario)",
                "North Korean nuclear ambitions, DPRK regime survival, US-ROK alliance",
                null));

        wars.add(new War("IMM004", "India–Pakistan Kashmir Escalation", "2024", null,
                Status.IMMINENT, Category.RELIGIOUS, "South Asia",
                Arrays.asList("India", "Pakistan", "Kashmir insurgents"),
                "Following a deadly terrorist attack in Indian-administered Kashmir in April 2025, India " +
                "launched Operation Sindoor, striking targets in Pakistan and Pakistan-administered Kashmir. " +
                "Both nuclear-armed nations exchanged fire before a ceasefire. Tensions remain at historic highs.",
                "Potentially millions (both nations are nuclear powers)",
                "Kashmir territorial dispute, religious nationalism (Hindu/Muslim), cross-border terrorism",
                null));

        wars.add(new War("IMM005", "South China Sea Conflict", "2024", null,
                Status.IMMINENT, Category.POLITICAL, "Southeast Asia",
                Arrays.asList("China", "Philippines", "Vietnam", "US (potential)", "Australia"),
                "Chinese coast guard vessels have rammed and water-cannoned Philippine supply boats heading " +
                "to the contested Second Thomas Shoal. The US-Philippines Mutual Defense Treaty could draw " +
                "Washington into any armed clash. Vietnam, Malaysia, and Brunei also have competing claims.",
                "Potentially high (US-China nuclear scenario)",
                "Territorial claims, undersea resources, Chinese expansionism, freedom of navigation",
                null));

        // ============================================================
        // HISTORICAL – WORLD WARS
        // ============================================================
        wars.add(new War("HIS001", "World War I", "1914", "1918",
                Status.HISTORICAL, Category.WORLD, "Europe / Global",
                Arrays.asList("Allied Powers (UK, France, Russia, USA, Italy)", "Central Powers (Germany, Austria-Hungary, Ottoman Empire)"),
                "The Great War was triggered by the assassination of Archduke Franz Ferdinand. A complex " +
                "web of alliances drew all major European powers into a devastating industrial-scale conflict. " +
                "The Ottoman Empire's collapse reshaped the Middle East. The Treaty of Versailles's harsh " +
                "terms planted seeds for World War II.",
                "17–20 million dead (military + civilian)",
                "Alliance systems, imperial rivalry, nationalism, assassination of Franz Ferdinand",
                "Allied victory; dissolution of Ottoman, Austro-Hungarian, Russian, German empires"));

        wars.add(new War("HIS002", "World War II", "1939", "1945",
                Status.HISTORICAL, Category.WORLD, "Global",
                Arrays.asList("Allies (USA, UK, USSR, France, China)", "Axis (Germany, Japan, Italy)"),
                "The deadliest conflict in human history. Nazi Germany's expansionism, Japan's Pacific " +
                "aggression, and the Holocaust (6 million Jews murdered) defined the war's character. " +
                "Ended with atomic bombings of Hiroshima and Nagasaki and establishment of the UN.",
                "70–85 million (est.) — 3% of world population",
                "Nazi ideology, fascism, Treaty of Versailles consequences, Japanese imperialism",
                "Allied victory; Cold War begins; United Nations founded; decolonization era"));

        // ============================================================
        // HISTORICAL – RELIGIOUS WARS
        // ============================================================
        wars.add(new War("HIS003", "The Crusades", "1095", "1291",
                Status.HISTORICAL, Category.RELIGIOUS, "Middle East / Europe",
                Arrays.asList("Catholic Church / European Kingdoms", "Muslim Caliphates / Sultanates"),
                "A series of eight major religious military campaigns sanctioned by the Latin Church to " +
                "recover the Holy Land from Muslim rule. The First Crusade captured Jerusalem (1099). " +
                "The campaigns deeply scarred Christian-Muslim relations and shaped medieval geopolitics.",
                "1–3 million (est.)",
                "Pope Urban II's call to reclaim Jerusalem; religious duty and promise of salvation",
                "Muslims ultimately retained the Holy Land; Latin kingdoms collapsed by 1291"));

        wars.add(new War("HIS004", "Thirty Years' War", "1618", "1648",
                Status.HISTORICAL, Category.RELIGIOUS, "Central Europe",
                Arrays.asList("Holy Roman Empire (Catholic)", "Protestant Princes", "Sweden", "France"),
                "The most destructive European conflict before WWI, killing a third of Germany's population. " +
                "Began as a Catholic-Protestant conflict within the Holy Roman Empire and evolved into a " +
                "broader political struggle. Ended with the Peace of Westphalia, establishing modern state sovereignty.",
                "8 million (military + famine + disease)",
                "Catholic-Protestant religious conflict; Bohemian Revolt; Habsburg power ambitions",
                "Peace of Westphalia (1648); principle of state sovereignty established"));

        wars.add(new War("HIS005", "Islamic Conquests", "632", "750",
                Status.HISTORICAL, Category.RELIGIOUS, "Middle East / North Africa / Persia",
                Arrays.asList("Rashidun Caliphate", "Umayyad Caliphate", "Byzantine Empire", "Sassanid Persian Empire"),
                "Following the death of Prophet Muhammad, Arab Muslim armies rapidly conquered vast territories " +
                "from Spain to Central Asia. The Byzantine Empire lost the Levant, Egypt, and North Africa; " +
                "the Sassanid Persian Empire was completely destroyed. This reshaped global religious demographics.",
                "Millions (over a century of campaigns)",
                "Religious expansion of Islam; political unification of Arab tribes under the Caliphate",
                "Islam spread from Arabia to Iberia, Persia, and North Africa; Byzantine Empire weakened"));

        wars.add(new War("HIS006", "French Wars of Religion", "1562", "1598",
                Status.HISTORICAL, Category.RELIGIOUS, "France",
                Arrays.asList("Huguenots (French Protestants)", "Catholic League", "French Crown"),
                "Eight civil wars between French Catholics and Protestants (Huguenots). The St. Bartholomew's " +
                "Day Massacre (1572) saw thousands of Huguenots slaughtered. Ended with the Edict of Nantes " +
                "granting Protestants civil rights.",
                "3 million (including disease and famine)",
                "Calvinist Reformation spreading in Catholic France; noble faction rivalry",
                "Edict of Nantes (1598); relative religious tolerance granted"));

        wars.add(new War("HIS007", "Reconquista", "718", "1492",
                Status.HISTORICAL, Category.RELIGIOUS, "Iberian Peninsula",
                Arrays.asList("Christian Kingdoms (Castile, Aragon, Portugal)", "Moorish Kingdoms (Al-Andalus)"),
                "A 774-year campaign by Christian kingdoms to reconquer the Iberian Peninsula from Muslim rule. " +
                "Concluded with the fall of Granada in 1492 — the same year Columbus sailed to the Americas. " +
                "Led to the Spanish Inquisition targeting Muslims and Jews.",
                "Millions over 8 centuries",
                "Christian desire to reclaim lands lost to Muslim conquest in 711 AD",
                "Complete Christian reconquest; expulsion of Muslims and Jews from Spain (1492)"));

        // ============================================================
        // HISTORICAL – POLITICAL / IMPERIAL WARS
        // ============================================================
        wars.add(new War("HIS008", "Mongol Conquests", "1206", "1368",
                Status.HISTORICAL, Category.POLITICAL, "Asia / Europe / Middle East",
                Arrays.asList("Mongol Empire (Genghis Khan and successors)", "China, Persia, Russia, Abbasid Caliphate, etc."),
                "The largest contiguous land empire in history, built through relentless military campaigns. " +
                "The Siege of Baghdad (1258) ended the Abbasid Caliphate. Genghis Khan's campaigns may have " +
                "killed 40 million — an estimated 10% of the world's population at the time.",
                "40 million (est.) — ~10% of world population",
                "Genghis Khan's unification of Mongol tribes and drive for conquest and tribute",
                "Mongol Empire fragmented into successor Khanates; massive demographic collapse in conquered regions"));

        wars.add(new War("HIS009", "Napoleonic Wars", "1803", "1815",
                Status.HISTORICAL, Category.POLITICAL, "Europe / Global",
                Arrays.asList("French Empire (Napoleon)", "Coalitions (UK, Russia, Prussia, Austria, Spain)"),
                "Napoleon Bonaparte's France clashed with successive coalitions of European powers. " +
                "Redrew European borders, spread revolutionary ideals, and ended with Napoleon's defeat " +
                "at Waterloo. The Congress of Vienna reshaped Europe for a century.",
                "3.5–6 million",
                "French Revolutionary ideals; Napoleon's imperial ambitions; British opposition to Continental domination",
                "Napoleon exiled to St. Helena; Congress of Vienna restores monarchies; modern European borders shaped"));

        wars.add(new War("HIS010", "American Civil War", "1861", "1865",
                Status.HISTORICAL, Category.CIVIL, "North America",
                Arrays.asList("Union (Northern States)", "Confederate States of America"),
                "The bloodiest war in American history, fought over slavery and states' rights. " +
                "Lincoln's Emancipation Proclamation (1863) transformed it into an explicit fight against slavery. " +
                "Union victory preserved the nation and abolished slavery (13th Amendment, 1865).",
                "620,000–750,000 (est.)",
                "Slavery, states' rights, economic differences between industrial North and agrarian South",
                "Union victory; abolition of slavery; Reconstruction era begins"));

        wars.add(new War("HIS011", "Vietnam War", "1955", "1975",
                Status.HISTORICAL, Category.IDEOLOGICAL, "Southeast Asia",
                Arrays.asList("North Vietnam (USSR/China-backed)", "South Vietnam", "United States", "South Korea, Australia"),
                "A Cold War proxy conflict pitting Communist North Vietnam against US-backed South Vietnam. " +
                "America's longest war until Afghanistan. The fall of Saigon (1975) unified Vietnam under " +
                "Communist rule. The war killed over 58,000 Americans and became deeply divisive domestically.",
                "3.5 million (est.)",
                "Communist expansion (domino theory), Ho Chi Minh's nationalist-communist movement, Cold War rivalry",
                "North Vietnamese victory; reunification of Vietnam under communist rule; US strategic failure"));

        wars.add(new War("HIS012", "Korean War", "1950", "1953",
                Status.HISTORICAL, Category.IDEOLOGICAL, "East Asia",
                Arrays.asList("South Korea + UN (USA, UK, etc.)", "North Korea", "China", "Soviet Union (air support)"),
                "North Korea's Soviet-backed invasion of the South triggered a UN-mandated response led by " +
                "the US. China entered when UN forces approached the Yalu River. Ended in armistice — " +
                "technically still no peace treaty. The 38th parallel remains one of the world's most fortified borders.",
                "1.2–1.5 million military; 2–3 million civilian",
                "Korean peninsula division post-WWII; Communist North Korean expansionism; Cold War",
                "Armistice (1953); Korean peninsula remains divided; no formal peace treaty to this day"));

        wars.add(new War("HIS013", "Peloponnesian War", "431 BC", "404 BC",
                Status.HISTORICAL, Category.POLITICAL, "Ancient Greece",
                Arrays.asList("Athens (Delian League)", "Sparta (Peloponnesian League)"),
                "The defining conflict of ancient Greece between the democratic Athens and oligarchic Sparta. " +
                "Thucydides documented it as a masterwork of historical analysis. Athens's plague killed a " +
                "quarter of its population. Sparta's ultimate victory weakened all Greek city-states, " +
                "enabling Macedonian (Alexander) domination.",
                "Unknown (tens of thousands)",
                "Athenian imperial expansion; Spartan fear of Athenian power; competing alliance systems",
                "Spartan victory; Athenian empire dissolved; Greek city-states weakened"));

        wars.add(new War("HIS014", "Punic Wars", "264 BC", "146 BC",
                Status.HISTORICAL, Category.POLITICAL, "Mediterranean",
                Arrays.asList("Roman Republic", "Carthage (Hannibal Barca)"),
                "Three wars between Rome and Carthage (in modern Tunisia) for Mediterranean supremacy. " +
                "Hannibal's crossing of the Alps with war elephants remains legendary. The Third Punic War " +
                "ended with Rome razing Carthage entirely and sowing its fields with salt.",
                "Unknown (hundreds of thousands)",
                "Competition for Mediterranean trade routes, Sicily, and Spain; Roman expansionism",
                "Roman victory; Carthage destroyed; Rome becomes dominant Mediterranean power"));

        wars.add(new War("HIS015", "Cold War (Proxy Conflicts)", "1947", "1991",
                Status.HISTORICAL, Category.IDEOLOGICAL, "Global",
                Arrays.asList("United States / NATO", "Soviet Union / Warsaw Pact"),
                "While the US and USSR never directly fought, they backed opposing sides in dozens of " +
                "proxy wars worldwide — Korea, Vietnam, Angola, Afghanistan, Nicaragua. The threat of " +
                "nuclear annihilation shaped all global politics. Ended with the Soviet collapse in 1991.",
                "Millions (across proxy conflicts)",
                "Ideological conflict between capitalism/democracy and Marxist-Leninist communism; nuclear arms race",
                "US/Western victory; Soviet Union dissolved; NATO expansion; end of bipolar world order"));

        wars.add(new War("HIS016", "Seven Years' War", "1756", "1763",
                Status.HISTORICAL, Category.POLITICAL, "Europe / Global",
                Arrays.asList("Britain, Prussia, Portugal", "France, Austria, Russia, Spain, Sweden"),
                "Called the 'first world war' by some historians — fought across five continents. Britain " +
                "vs. France for global colonial dominance. Britain's victory secured Canada, India, and " +
                "Caribbean territories, establishing the British Empire as the dominant global power.",
                "1.4 million military; ~1 million civilian",
                "Colonial rivalry between Britain and France; European balance-of-power politics",
                "British triumph; France cedes Canada and India; British global dominance established"));

        wars.add(new War("HIS017", "Indo-Pakistani Wars", "1947", "1999",
                Status.HISTORICAL, Category.POLITICAL, "South Asia",
                Arrays.asList("India", "Pakistan"),
                "Four major wars (1947, 1965, 1971, 1999 Kargil) plus numerous skirmishes over Kashmir " +
                "and other disputes. The 1971 war created Bangladesh (East Pakistan). Both nations acquired " +
                "nuclear weapons by 1998, transforming the conflict's stakes permanently.",
                "100,000+ across all conflicts",
                "Partition of British India (1947), Kashmir dispute, religious nationalism",
                "Mixed outcomes; Kashmir divided; Bangladesh created (1971); nuclear standoff ongoing"));

        wars.add(new War("HIS018", "Iran-Iraq War", "1980", "1988",
                Status.HISTORICAL, Category.POLITICAL, "Middle East",
                Arrays.asList("Iraq (Saddam Hussein)", "Iran (Khomeini)"),
                "Saddam Hussein invaded Iran to exploit post-revolutionary chaos and gain control of " +
                "the Shatt al-Arab waterway. Iraq used chemical weapons extensively. Over a million " +
                "died in trench warfare reminiscent of WWI. Ended in a stalemate with no territorial change.",
                "500,000–1,000,000",
                "Saddam's territorial ambitions; fear of Iranian Shia revolutionary spread; Western support for Iraq",
                "Stalemate; no territorial changes; devastating losses for both sides"));

        wars.add(new War("HIS019", "Gulf War", "1990", "1991",
                Status.HISTORICAL, Category.POLITICAL, "Middle East",
                Arrays.asList("US-led Coalition (34 nations)", "Iraq (Saddam Hussein)"),
                "Iraq invaded and annexed Kuwait in August 1990. A US-led UN coalition of 34 nations " +
                "launched Operation Desert Storm, expelling Iraqi forces in 100 hours of ground combat. " +
                "The first televised war; precision bombing changed modern warfare doctrine.",
                "25,000–75,000",
                "Iraq's annexation of Kuwait; oil resources; Saddam's ambitions to dominate the Gulf",
                "Coalition victory; Iraq expelled from Kuwait; Saddam retained power in Baghdad"));

        wars.add(new War("HIS020", "Second Congo War", "1998", "2003",
                Status.HISTORICAL, Category.POLITICAL, "Central Africa",
                Arrays.asList("DRC (supported by Angola, Zimbabwe, Namibia)", "Rwanda, Uganda, Burundi + rebel groups"),
                "Called 'Africa's World War' with nine nations and dozens of armed groups involved. " +
                "Fought primarily over DRC's enormous mineral wealth (coltan, gold, diamonds). " +
                "The deadliest conflict since WWII with most deaths from disease and famine.",
                "3.8–5.4 million (mostly disease/famine)",
                "Post-Rwandan genocide fallout; mineral wealth exploitation; regional power competition",
                "Formal end; Lusaka Ceasefire; though violence continues in eastern DRC to this day"));

        wars.add(new War("HIS021", "Rwandan Genocide", "1994", "1994",
                Status.HISTORICAL, Category.ETHNIC, "East Africa",
                Arrays.asList("Hutu militias (Interahamwe)", "Tutsi population + moderate Hutus"),
                "In just 100 days, Hutu extremists massacred approximately 800,000 Tutsi and moderate Hutu. " +
                "Radio broadcasts directed killers to victims. The international community — including the UN — " +
                "largely failed to intervene. One of the fastest genocides in history.",
                "500,000–800,000 (est.)",
                "Colonial Belgian divide-and-rule policies; decades of Hutu-Tutsi ethnic tensions; political extremism",
                "RPF (Tutsi) forces defeated the genocidaires; new government formed; International Criminal Tribunal established"));

        wars.add(new War("HIS022", "Bosnian War", "1992", "1995",
                Status.HISTORICAL, Category.ETHNIC, "Balkans / Europe",
                Arrays.asList("Bosnia-Herzegovina", "Republika Srpska (Serbia-backed)", "Croatia"),
                "Following Yugoslavia's dissolution, Bosnian Serb forces besieged Sarajevo (longest siege " +
                "of a capital in modern warfare — 44 months) and committed the Srebrenica massacre of " +
                "~8,000 Bosniak men and boys. NATO air strikes helped end the conflict.",
                "100,000+",
                "Yugoslav dissolution, Serbian nationalism (Milošević), ethnic cleansing campaigns",
                "Dayton Agreement (1995); Bosnia divided into two entities; ICTY established"));

        wars.add(new War("HIS023", "Afghan-Soviet War", "1979", "1989",
                Status.HISTORICAL, Category.IDEOLOGICAL, "South/Central Asia",
                Arrays.asList("USSR", "Afghan Mujahideen (USA/Pakistan/Saudi-backed)"),
                "The Soviet Union invaded Afghanistan to support a Communist government. The CIA's Operation " +
                "Cyclone armed Mujahideen fighters. The USSR withdrew after 10 years. The war is often cited " +
                "as a major factor in Soviet collapse. It also created the jihadist networks that spawned al-Qaeda.",
                "1–2 million Afghan civilians; 15,000 Soviet troops",
                "Soviet desire to maintain a Communist buffer state; Mujahideen resistance; Cold War proxy conflict",
                "Soviet withdrawal (1989); Communist government collapsed 1992; civil war → Taliban takeover (1996)"));

        wars.add(new War("HIS024", "War on Terror (Afghanistan)", "2001", "2021",
                Status.HISTORICAL, Category.IDEOLOGICAL, "Central Asia",
                Arrays.asList("United States + NATO coalition", "Taliban", "Al-Qaeda"),
                "Launched after the September 11, 2001 attacks, America's longest war (20 years) toppled " +
                "the Taliban and built a new Afghan state — but the Taliban retook power within weeks of " +
                "the US withdrawal in August 2021, rendering two decades of effort largely void.",
                "176,000+ (direct war deaths)",
                "9/11 attacks by al-Qaeda; Taliban harboring bin Laden; global War on Terror doctrine",
                "Taliban returned to power (August 2021); US strategic failure after $2 trillion spent"));

        wars.add(new War("HIS025", "Iraq War", "2003", "2011",
                Status.HISTORICAL, Category.POLITICAL, "Middle East",
                Arrays.asList("United States, UK, Coalition", "Saddam Hussein's Iraq", "Iraqi insurgency"),
                "The US-led invasion based on (disputed/false) claims of Iraqi WMDs toppled Saddam Hussein. " +
                "Post-invasion, a brutal insurgency emerged. The power vacuum created the conditions for " +
                "ISIS's rise. No WMDs were ever found. The war is considered one of the greatest foreign policy blunders in US history.",
                "184,000–208,000 (documented violent deaths)",
                "Alleged WMDs (false), post-9/11 US security doctrine, desire to reshape Middle East",
                "Saddam toppled and executed; US withdrawal; power vacuum led to ISIS; Iranian influence grew"));

        wars.add(new War("HIS026", "Hundred Years War", "1337", "1453",
                Status.HISTORICAL, Category.POLITICAL, "Western Europe",
                Arrays.asList("Kingdom of England", "Kingdom of France"),
                "A series of conflicts between England and France over the French throne. Joan of Arc " +
                "became a national hero rallying French forces. The war saw the first major use of " +
                "English longbows and later gunpowder, transforming medieval warfare.",
                "2–3 million (military + Black Death era)",
                "English claims to the French crown; feudal territorial disputes",
                "French victory; England expelled from most of France; French national identity solidified"));

        wars.add(new War("HIS027", "Partition of India", "1947", "1948",
                Status.HISTORICAL, Category.RELIGIOUS, "South Asia",
                Arrays.asList("India (Hindu majority)", "Pakistan (Muslim majority)"),
                "British India's partition into Hindu-majority India and Muslim-majority Pakistan caused " +
                "the largest mass migration in history — 14 million people displaced. Communal violence " +
                "between Hindus, Muslims, and Sikhs killed up to 2 million. It also sparked the first " +
                "India-Pakistan war over Kashmir.",
                "500,000–2,000,000 (partition violence)",
                "British Raj withdrawal; Muslim League's demand for a separate Muslim state; religious nationalism",
                "Two independent nations created; mass migrations; Kashmir dispute became permanent flash point"));

        wars.add(new War("HIS028", "Spanish Civil War", "1936", "1939",
                Status.HISTORICAL, Category.IDEOLOGICAL, "Europe",
                Arrays.asList("Republican Government (USSR-backed)", "Nationalist Forces (Nazi Germany/Italy-backed, Franco)"),
                "A brutal dress rehearsal for WWII. Nazi Germany tested its air force (Guernica bombing) " +
                "while the USSR backed the Republic. Became a rallying cause for international leftists. " +
                "Franco's Nationalist victory established a fascist dictatorship until 1975.",
                "500,000+",
                "Leftist Republican government vs. right-wing military rebellion; fascism vs. communism",
                "Nationalist victory; Franco dictatorship; rehearsal for WWII tactics proven"));
    }

    public static List<War> getAll() { return new ArrayList<>(wars); }

    public static List<War> getByStatus(Status status) {
        List<War> result = new ArrayList<>();
        for (War w : wars) if (w.getStatus() == status) result.add(w);
        return result;
    }

    public static List<War> getByCategory(Category category) {
        List<War> result = new ArrayList<>();
        for (War w : wars) if (w.getCategory() == category) result.add(w);
        return result;
    }

    public static List<War> search(String query) {
        String q = query.toLowerCase();
        List<War> result = new ArrayList<>();
        for (War w : wars) {
            if (w.getName().toLowerCase().contains(q) ||
                w.getRegion().toLowerCase().contains(q) ||
                w.getDescription().toLowerCase().contains(q) ||
                w.getCause().toLowerCase().contains(q)) {
                result.add(w);
            }
        }
        return result;
    }
}
