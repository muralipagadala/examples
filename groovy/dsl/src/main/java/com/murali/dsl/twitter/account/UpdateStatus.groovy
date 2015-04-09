import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

def twitter = new TwitterFactory().getInstance()
twitter.setOAuthConsumer('rvAzKmBNZ6DsoeMM7xDdKUKQ5', 'k2UXxMZqWQsssR1CJCF5owHfbuODPJdCFgUaAkIiwdcTntnFVZ');

// get the URL to request access to Twitter acct
def requestToken = twitter.getOAuthRequestToken();
def authUrl = requestToken.getAuthorizationURL()
println "Open the following URL and grant access to your account: $authUrl"

// take the PIN and get access token
println 'Enter the PIN:'
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
String pin = ''
pin = br.readLine();
AccessToken accessToken = twitter.getOAuthAccessToken(requestToken, pin);

String message = "from Groovy w/ pin" + pin
Status status = twitter.updateStatus(message);
System.out.println("Successfully sent " + message);