#import "RCTPBKDF2.h"
#import "PBKDF2.h"

@implementation RCTPBKDF2

RCT_EXPORT_MODULE()

RCT_EXPORT_METHOD(derivationKey:(NSString *)password salt:(NSString *)salt iterations:(nonnull int *)iterations
                  resolver:(RCTPromiseResolveBlock)resolve
                  rejecter:(RCTPromiseRejectBlock)reject) {
    NSError *error = nil;
    NSString *data = [PBKDF2 derivationKey:password salt:salt iterations: iterations];
    if (data == nil) {
        reject(@"keygen_fail", @"Key generation failed", error);
    } else {
        resolve(data);
    }
}

@end
