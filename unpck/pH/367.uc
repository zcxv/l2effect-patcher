class 367 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect66
		AttachOn=AM_LA
		SpawnDelay=1.000000
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		EffectClass=Class'LineageEffect.ph_dance_of_medusa_ta'
	End Object
	Desc="댄스 오브 메두사" //Dance of Medusa
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect66',SpecificStage=0)
}