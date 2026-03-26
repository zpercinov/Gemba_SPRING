<div align="center">
<img src="https://upload.wikimedia.org/wikipedia/sr/5/57/%D0%A4%D0%9E%D0%9D_%D0%91%D0%B5%D0%BE%D0%B3%D1%80%D0%B0%D0%B4_%28%D0%BB%D0%BE%D0%B3%D0%BE%29.png" alt="FON logo" width="300"/>
<br/>

## **UNIVERZITET U BEOGRADU**  
### **FAKULTET ORGANIZACIONIH NAUKA**

Specijalističke akademske studije  
**Modul: Java tehnologije**

---

### **Seminarski rad iz predmeta: Java okviri**



## Softverski sistem za praćenje i kontrolu poslovne izvrsnosti primenom Spring Boot Java okvira  
## Veb aplikacija „Gemba“

<img src="src/main/webapp/img/img_gemba.png" alt="Gemba logo" width="180"/>
</div>

---

### 🎯 Cilj projekta

Razvoj veb aplikacije koja omogućava:

- 📝 unos i praćenje Gemba provera  
- 🎯 definisanje aktivnosti po vrstama Gemba  
- ⚠️ evidenciju zamerki i odstupanja  
- 📊 statističke prikaze i izveštaje  
- 👥 administraciju korisnika i uloga  

---

## 🚀 Pokretanje projekta

### 1. Kloniranje repozitorijuma

```bash
git clone https://github.com/zpercinov/Gemba_SPRING.git
cd Gemba_SPRING
```

---

### 🖥️ 2. Kloniranje putem NetBeans IDE-a

```markdown
1. Otvoriti NetBeans IDE  
2. Kliknuti na **Team → Git → Clone**  

3. U polje **Repository URL** uneti:

```
https://github.com/zpercinov/Gemba_SPRING.git
```

4. Kliknuti **Next** kroz korake  
5. Izabrati lokalni folder za projekat  
6. Kliknuti **Finish**  
7. Projekat će se automatski otvoriti u NetBeans-u  
```

---


## 🗄️ Baza podataka

Aplikacija koristi **SQLite** bazu podataka, namenjenu za jednostavno lokalno testiranje bez potrebe za dodatnom konfiguracijom servera baze.

Prilikom prvog pokretanja aplikacije:

- baza se automatski kreira (ukoliko ne postoji)  
- inicijalni šifarnici i podaci se automatski učitavaju  
- nije potrebna ručna inicijalizacija  

---

## ⚠️ Napomena

Aplikacija je razvijena u edukativne svrhe i koristi **SQLite bazu kao testno okruženje**.  
Zbog ograničenja ove baze i načina implementacije, **aplikacija nije namenjena za produkcionu upotrebu**.

---

## 🚀 Pokretanje u NetBeans-u

1. Otvoriti NetBeans IDE  
2. Kliknuti na **File → Open Project**  
3. Izabrati folder `Gemba_SPRING`  
4. Desni klik na projekat → **Run**  

---

## 🌐 Pristup aplikaciji

```
http://localhost:8080/gemba-spring/
```

---

## 🔐 Default korisnik

| Username | Password | Role |
|----------|---------|------|
| admin    | admin123 | Administrator |

---

## 👨‍💻 Autor

**Zoran Perčinov**  
Specijalističke akademske studije – Java tehnologije  
Fakultet organizacionih nauka  
Univerzitet u Beogradu  
📧 Email: [zp20244151@student.fon.bg.ac.rs](mailto:zp20244151@student.fon.bg.ac.rs)

---

## 👨‍🏫 Mentor

**prof. Dr Ilija D. Antović**  
Fakultet organizacionih nauka  
Univerzitet u Beogradu  
