
---

### **1. Computer Architecture**
- **Basics**: Computers operate in binary (bits: 0 or 1; bytes: 8 bits). Data scales from kilobytes to terabytes.
- **Disk Storage**: 
  - Non-volatile (data persists without power).
  - Types: HDD (80-160 MB/s) vs. SSD (500-3500 MB/s).
  - Stores OS, apps, and user files (100s GB to TBs).
- **RAM (Random Access Memory)**:
  - Volatile (data lost without power).
  - Holds active data (variables, runtime stack).
  - Faster than disk (5,000+ MB/s); sizes from GBs to 100s GBs.
- **Cache**:
  - Smaller (MBs), faster than RAM (L1: few nanoseconds).
  - Stores frequently used data to optimize CPU access.
  - Levels: L1, L2, L3 (checked before RAM).
- **CPU**:
  - Executes instructions (fetch, decode, execute).
  - Requires code compiled into machine code (from high-level languages like Java, Python).
- **Motherboard**: Connects all components for data flow.

---

### **2. Production App Architecture**
- **CI/CD Pipeline**:
  - Automates code deployment (e.g., Jenkins, GitHub Actions).
  - Ensures testing and production rollout without manual steps.
- **Load Balancers & Reverse Proxies**:
  - Distribute traffic across servers (e.g., NGINX).
  - Maintain performance during traffic spikes.
- **External Storage**: Network-connected, separate from production servers.
- **Logging & Monitoring**:
  - Tracks system interactions (e.g., PM2 for backend, Sentry for frontend).
  - Stores logs externally for analysis.
- **Alerting**:
  - Notifies devs of issues (e.g., Slack integration).
  - Detects anomalies (e.g., failed requests).
- **Debugging Process**:
  - Identify issues via logs, replicate in staging (not production), fix with hotfixes, then permanent solutions.

---

### **3. Design Requirements**
- **Core Principles**:
  - Scalability: Grows with users.
  - Maintainability: Easy to update.
  - Efficiency: Optimal resource use.
  - Resilience: Handles failures gracefully.
- **Key Elements**:
  - Moving Data: Fast, secure transfers.
  - Storing Data: Access patterns, indexing, backups.
  - Transforming Data: Converts raw data into insights.
- **CAP Theorem**:
  - Consistency: All nodes have the same data.
  - Availability: System always responds.
  - Partition Tolerance: Works despite network splits.
  - Tradeoff: Only 2 of 3 achievable (e.g., banking prioritizes consistency + partition tolerance).
- **Availability**:
  - Measured as uptime (e.g., 99.9% = 8.76 hrs downtime/year; 99.999% = 5 mins).
- **SLOs & SLAs**:
  - SLO: Internal goals (e.g., 300ms response, 99.9% uptime).
  - SLA: User contracts with penalties for breaches.
- **Performance Metrics**:
  - Throughput: Data handled over time (RPS, QPS, bytes/s).
  - Latency: Time for a request to complete.
  - Tradeoffs: High throughput may increase latency.

---

### **4. Networking**
- **IP Addresses**:
  - IPv4 (32-bit, ~4B addresses) vs. IPv6 (128-bit, vastly more).
  - Packets include IP headers (sender/receiver IPs).
- **TCP**:
  - Reliable, connection-oriented (3-way handshake).
  - Uses sequence numbers, headers with port info.
- **UDP**:
  - Faster, unreliable, no connection.
  - Ideal for video calls, streaming (some loss acceptable).
- **DNS**:
  - Translates domain names to IPs (e.g., A records for IPv4, AAAA for IPv6).
  - Managed by ICANN, registrars (e.g., Namecheap).
- **Infrastructure**:
  - Public (unique globally) vs. Private (unique locally) IPs.
  - Ports identify services (e.g., 80 for HTTP).
  - Firewalls control traffic.

---

### **5. Application Layer Protocols**
- **HTTP**:
  - Request-response, stateless (no memory between requests).
  - Methods: GET (fetch), POST (create), PUT/PATCH (update), DELETE (remove).
  - Status Codes: 200 (success), 300 (redirect), 400 (client error), 500 (server error).
- **WebSockets**: Two-way, persistent connection for real-time (e.g., chat, stock updates).
- **Email**: SMTP (send), IMAP (access across devices), POP3 (download to one device).
- **File Transfer**: FTP (file transfers), SSH (secure remote access).
- **Real-Time**: WebRTC (voice/video), MQTT (lightweight for IoT), AMQP (enterprise messaging).
- **RPC**: Remote function calls, abstracts network details (used in HTTP, SMTP).

---

### **6. API Design**
- **Basics**:
  - Defines CRUD operations (e.g., POST /products, GET /products/:id).
  - Protocols: HTTP, WebSockets; Formats: JSON, XML, Protobuf.
- **Paradigms**:
  - REST: Stateless, uses HTTP methods, JSON-based, may over/under-fetch.
  - GraphQL: Precise data requests, POST-only, complex queries impact performance.
  - gRPC: HTTP/2, Protobuf, efficient for microservices, less readable.
- **Best Practices**:
  - Idempotent GETs (no data mutation).
  - Backward compatibility (e.g., versioning: /v2/products).
  - Rate limiting, CORS for security.

---

### **7. Caching & CDNs**
- **Caching**:
  - Stores data for faster access.
  - Types: Browser (local), Server (e.g., Redis), Database (query results).
  - Strategies: Write-around, Write-through, Write-back.
  - Eviction: LRU, FIFO, LFU.
- **CDNs**:
  - Geographically distributed servers for static content (e.g., images, CSS).
  - Pull (auto-fetches) vs. Push (manual upload).
  - Benefits: Low latency, high availability, security (e.g., DDoS protection).

---

### **8. Proxy Servers**
- **Forward Proxy**:
  - Sits between client and internet, hides client IP.
  - Uses: Anonymity, caching, access control (e.g., Instagram proxies).
- **Reverse Proxy**:
  - Sits before servers, hides server identity.
  - Uses: Load balancing, SSL offloading, WAF, CDN.

---

### **9. Load Balancers**
- **Purpose**: Distributes traffic for scalability, reliability.
- **Algorithms**:
  - Round Robin, Least Connections, Least Response Time, IP Hashing.
  - Weighted (capacity-based), Geographical, Consistent Hashing.
- **Health Checks**: Ensures traffic goes to live servers.
- **Types**: Hardware (F5), Software (NGINX), Cloud (AWS ELB).
- **Failure Mitigation**: Redundancy, failover, auto-scaling.

---

### **10. Databases**
- **Types**:
  - Relational (SQL): Tables, ACID-compliant (e.g., MySQL).
  - NoSQL: Flexible, scalable (e.g., MongoDB, Redis).
  - In-Memory: Fast, volatile (e.g., Redis).
- **Scaling**:
  - Vertical: Upgrade server (limited).
  - Horizontal: Add servers (sharding, replication).
- **Sharding**: Splits data (range, directory, geo-based).
- **Replication**: Copies data (master-slave, master-master).
- **Performance**: Caching, indexing, query optimization.
- **CAP Theorem**: Prioritize 2 of consistency, availability, partition tolerance.

---

These notes cover the essentials of system design, from hardware to distributed systems, with practical examples and tradeoffs highlighted for interview readiness.