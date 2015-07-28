class 4616 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect1
		AttachOn=AM_LA
		SpawnDelay=360.000000
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		bSizeScale=True
		EffectClass=Class'LineageEffect.wh_recharge_ta'
	End Object
	Desc="위장 석화" //Chemical camouflage
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect1',SpecificStage=0)
}