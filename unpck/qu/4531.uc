class 4531 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect3
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		bSpawnOnTarget=True
		bSizeScale=True
		EffectClass=Class'LineageEffect.wh_recharge_ta'
		bOnMultiTarget=True
	End Object
	Desc="Quest Summoned MP Heal" //Quest Summoned MP Heal
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect3',SpecificStage=0)
}