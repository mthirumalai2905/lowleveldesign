public class ProxyPatternSingleClass {

    interface Internet {
        void connectTo(String serverHost);
    }

    static class RealInternet implements Internet {
        public void connectTo(String serverHost) {
            System.out.println("Connecting to " + serverHost);
        }
    }

    static class ProxyInternet implements Internet {
        private Internet realInternet = new RealInternet();
        private static final java.util.Set<String> bannedSites = new java.util.HashSet<>();

        static {
            bannedSites.add("abc.com");
            bannedSites.add("xyz.com");
        }

        public void connectTo(String serverHost) {
            if (bannedSites.contains(serverHost.toLowerCase())) {
                System.out.println("Access Denied to " + serverHost);
            } else {
                realInternet.connectTo(serverHost);
            }
        }
    }

    public static void main(String[] args) {
        Internet internet = new ProxyInternet();
        internet.connectTo("geeksforgeeks.org");
        internet.connectTo("abc.com");
    }
}
