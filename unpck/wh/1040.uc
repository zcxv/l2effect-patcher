class 1040 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect7
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		bSizeScale=True
		EffectClass=Class'LineageEffect.wh_heal_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect8
		AttachOn=AM_LA
		bSpawnOnTarget=True
		bSizeScale=True
		EffectClass=Class'LineageEffect.wh_shield_ta'
		bOnMultiTarget=True
	End Object
	Desc="실드" //Shield
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect7',SpecificStage=0)
	ShotActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect8',SpecificStage=0)
}