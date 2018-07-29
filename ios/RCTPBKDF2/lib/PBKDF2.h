#import <Foundation/Foundation.h>

@interface PBKDF2 : NSObject
+ (NSString *) derivationKey:(NSString *)password salt: (NSString *)salt iterations: (nonnull NSNumber *)iterations;
+ (NSString *) toHex: (NSData *)nsdata;
@end
