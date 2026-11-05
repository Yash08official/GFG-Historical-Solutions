# GFG Historical Solutions Export Report

**User Handle:** `yashwasankar008`  
**Profile URL:** [https://www.geeksforgeeks.org/profile/yashwasankar008?tab=overview](https://www.geeksforgeeks.org/profile/yashwasankar008?tab=overview)  
**Export Date:** November 5, 2026  
**Export Directory:** `D:\GFG-Historical-Export`  
**Source Challenge Repository (Read-Only):** `D:\GFG-21-days-Challenge`  

---

## 1. Executive Summary

| Metric | Count | Status / Notes |
| :--- | :---: | :--- |
| **Total Solved Count Reported by GFG Profile** | **595** | Official count confirmed on GFG profile |
| **Total Unique Problems Fetched** | **595** | 100% verified unique metadata records |
| **Duplicate Problem Records** | **0** | Verified zero duplicates across IDs and slugs |
| **Problems with Original Code Recovered** | **61** | Mapped from local 62-day challenge repository |
| **Total Solution Files Recovered** | **92** | Java (61 files) & JavaScript (31 files) |
| **Problems with Unavailable Code** | **534** | Private submission code on GFG requires user login |
| **SHA-256 Hash Verification** | **100% Pass** | Every copied solution file matches its source byte-for-byte |

---

## 2. Problem Difficulty Breakdown

| Difficulty | Total Solved | Code Recovered | Code Unavailable |
| :--- | :---: | :---: | :---: |
| **Hard** | 235 | 4 | 231 |
| **Medium** | 209 | 27 | 182 |
| **Easy** | 106 | 26 | 80 |
| **Basic** | 45 | 4 | 41 |
| **Total** | **595** | **61** | **534** |

---

## 3. Data Retrieval Methodology

### 3.1 Profile Architecture & Endpoint Discovery
GeeksforGeeks uses Next.js App Router for profile rendering. By analyzing the frontend JavaScript bundles (`page-d260006684c1ef03.js` and `7223-ee45b4cb368f3c2e.js`), we discovered the internal API used to populate the profile's Coding Score / Activity tab:

- **Endpoint**: `POST https://practiceapi.geeksforgeeks.org/api/v1/user/problems/submissions/`
- **Request Body**:
  ```json
  {
    "handle": "yashwasankar008",
    "requestType": "",
    "year": "",
    "month": ""
  }
  ```
- **Response**: Returns HTTP 200 containing the complete catalog of all 595 problems solved by the user with their official problem ID (`pid`), title (`pname`), slug (`slug`), submission timestamp (`user_subtime`), programming language (`lang`), and difficulty tier.

### 3.2 Solution Code Access Restrictions
- GFG stores user submission code privately under `https://practiceapi.geeksforgeeks.org/api/v1/problems/{slug}/submissions/`.
- Unauthenticated requests return `HTTP 403 {"error": {"code": 403, "message": "Session Expired"}}`.
- In strict adherence to your instructions, no authentication bypass, credential harvesting, or fake code generation was performed. Problems without local files are cleanly cataloged in `unavailable_problems.csv`.

---

## 4. Local Solutions Recovery from `D:\GFG-21-days-Challenge`

Your existing repository `D:\GFG-21-days-Challenge` was accessed in **strictly read-only mode**. No files were modified, renamed, deleted, or moved.

### 4.1 Chronological & Content Mapping
The 62 days in your challenge correspond to the **GeekStreak 2024 Challenge** (September 12, 2024 to November 11, 2024). We mapped each Day folder to the exact GFG problem using:
1. **Consecutive POTD Submission Timestamps**: Each Day folder strictly aligns with the corresponding date in your GFG submission timestamps.
2. **Problem Statement & Function Signatures**: Verified against `readme.md` descriptions, function signatures, and test cases.
3. **GFG Title Renaming Reconciliation**: GFG updated several problem titles over time (e.g. `total-count2415` became *Split Array Elements into Bounded Parts*; `buildings-receiving-sunlight3032` became *Buildings with Sunlight*). All were reconciled using the unique problem slugs and IDs.

### 4.2 Mapping Summary
- **Day_1 to Day_61**: 61 problems matched 1-to-1 to unique GFG solved problems.
- **Day_62**: Contains *[2070. Most Beautiful Item for Each Query]*, which is a **LeetCode problem** solved during your personal 100-day extension, not a GeeksforGeeks problem. It is documented in `solution_mapping.csv` and excluded from the GFG archive.

---

## 5. Export Structure

```
D:\GFG-Historical-Export\
├── solved_problems.csv        # Comprehensive dataset of all 595 solved problems
├── solved_problems.json       # JSON export with complete problem records
├── unavailable_problems.csv   # 534 problems where code requires GFG session
├── solution_mapping.csv       # 1-to-1 mapping table with SHA-256 verification
├── FETCH_REPORT.md            # This detailed export report
└── solutions/
    ├── Easy/                  # 26 problem solution folders
    ├── Medium/                # 27 problem solution folders
    ├── Hard/                  # 4 problem solution folders
    └── Basic/                 # 4 problem solution folders
```

---

## 6. Verification and Integrity Check

1. **Record Count**: Exactly **595** records in `solved_problems.csv` and `solved_problems.json`.
2. **Deduplication**: 0 duplicate Problem IDs, 0 duplicate slugs.
3. **No Fabricated Data**: Every problem title, slug, ID, language, and timestamp is directly from GFG's API.
4. **Byte-Level Integrity**: All 92 copied solution source files match their source files in `D:\GFG-21-days-Challenge` with identical SHA-256 hashes.
